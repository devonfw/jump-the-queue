package com.cap.jumpthequeue.queuemanagement.logic.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao.AccessCodeDao;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.QueueDao;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of queuemanagement
 */
@Named
@Transactional
public class QueuemanagementImpl extends AbstractComponentFacade implements Queuemanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(QueuemanagementImpl.class);

  /** @see #getQueueDao() */
  @Inject
  private QueueDao queueDao;

  /** @see #getAccessCodeDao() */
  @Inject
  private AccessCodeDao accessCodeDao;

  /**
   * The constructor.
   */
  public QueuemanagementImpl() {
    super();
  }

  @Override
  public QueueEto findQueue(Long id) {

    LOG.debug("Get Queue with id {} from database.", id);
    return getBeanMapper().map(getQueueDao().findOne(id), QueueEto.class);
  }

  @Override
  public PaginatedListTo<QueueEto> findQueueEtos(QueueSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<QueueEntity> queues = getQueueDao().findQueues(criteria);
    return mapPaginatedEntityList(queues, QueueEto.class);
  }

  @Override
  public boolean deleteQueue(Long queueId) {

    QueueEntity queue = getQueueDao().find(queueId);
    getQueueDao().delete(queue);
    LOG.debug("The queue with id '{}' has been deleted.", queueId);
    return true;
  }

  @Override
  public QueueEto saveQueue(QueueEto queue) {

    Objects.requireNonNull(queue, "queue");
    QueueEntity queueEntity = getBeanMapper().map(queue, QueueEntity.class);

    // initialize, validate queueEntity here if necessary
    QueueEntity resultEntity = getQueueDao().save(queueEntity);
    LOG.debug("Queue with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, QueueEto.class);
  }

  /**
   * Returns the field 'queueDao'.
   *
   * @return the {@link QueueDao} instance.
   */
  public QueueDao getQueueDao() {

    return this.queueDao;
  }

  @Override
  public QueueEto updateQueue(long id, QueueEto newqueue) {

    // Get queue
    QueueEntity queue = getQueueDao().find(id);
    if (queue.equals(null)) {
      throw new InternalServerErrorException();
    }

    // Make modifications - Logo missing

    // queue.setLogo(newqueue.getLogo()); Logo variable in Queue no implemented yet

    queue.setDescriptionText(newqueue.getDescriptionText());

    // Save modification
    getQueueDao().save(queue);
    LOG.info("Queue with id {} updated.", queue.getId());

    // return modified Queue
    return getBeanMapper().map(queue, QueueEto.class);
  }

  /**
   * Pass next turn -- IN PROCESS
   *
   * @return AccessCodeETo
   */
  @Override
  public AccessCodeCto attendQueue(long id) {

    // End Actual AccesCode
    // Find Actual attending AccessCode
    AccessCodeSearchCriteriaTo accescodecriteria = new AccessCodeSearchCriteriaTo();
    accescodecriteria.setQueueId(id);
    accescodecriteria.setEndTime(null);
    PaginatedListTo<AccessCodeEntity> attendingAccessCodeList =
        getAccessCodeDao().findAttendingAccessCode(accescodecriteria);

    if (attendingAccessCodeList.getResult().size() > 0) {
      AccessCodeEntity attendingAccessCode =
          attendingAccessCodeList.getResult().get(attendingAccessCodeList.getResult().size() - 1);
      // Write end time
      attendingAccessCode.setEndTime(Timestamp.from(Instant.now()));
      getAccessCodeDao().save(attendingAccessCode);
    }
    // ListAccesCode in this queue

    // Priority
    AccessCodeEntity priorityCode = getAccessCodeDao().findNewAttendAccessCode(id, true);

    // Visitor
    AccessCodeEntity visitorCode = getAccessCodeDao().findNewAttendAccessCode(id, false);

    if (priorityCode == null && visitorCode == null) {
      throw new NotFoundException();
    }

    AccessCodeEntity actCode = (priorityCode != null) ? priorityCode : visitorCode;

    actCode.setStartTime(Timestamp.from(Instant.now()));

    getAccessCodeDao().save(actCode);

    // Log for info
    String letter = actCode.getPriority() ? "A" : "Q";

    LOG.info("AccessCode with code '{}{} ' has been created.", letter, actCode.getCode());
    AccessCodeCto cto = new AccessCodeCto();
    cto.setAccessCode(getBeanMapper().map(actCode, AccessCodeEto.class));
    cto.setQueue(getBeanMapper().map(actCode.getQueue(), QueueEto.class));

    return cto;
  }

  /**
   * @return
   */
  private AccessCodeDao getAccessCodeDao() {

    return this.accessCodeDao;
  }

}