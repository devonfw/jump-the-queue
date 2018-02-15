package com.cap.jumpthequeue.queuemanagement.logic.impl;

import java.sql.Timestamp;
import java.time.Instant;

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
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.TermsEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.QueueDao;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.TermsDao;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsEto;

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

  /** @see #getQueueDao() */
  @Inject
  private TermsDao termsDao;

  /** @see #getAccessCodeDao() */
  @Inject
  private AccessCodeDao accessCodeDao;

  /**
   * The constructor.
   */
  public QueuemanagementImpl() {
    super();
  }

  /**
   * Returns the field 'queueDao'.
   *
   * @return the {@link QueueDao} instance.
   */
  public QueueDao getQueueDao() {

    return this.queueDao;
  }

  /**
   * Returns the field 'termsDao'.
   *
   * @return the {@link TermsDao} instance.
   */
  public TermsDao getTermsDao() {

    return this.termsDao;
  }

  /**
   * @return
   */
  private AccessCodeDao getAccessCodeDao() {

    return this.accessCodeDao;
  }

  // Update Queue info
  @Override
  public QueueEto updateQueue(long queueid, QueueEto newqueue) {

    // Get queue
    QueueEntity queue = getQueueByQueueId(queueid);
    // Make modifications - Logo missing - Only for fields existing in newqueue
    if (!newqueue.getDescriptionText().isEmpty()) {
      queue.setDescriptionText(newqueue.getDescriptionText());
    }
    if (newqueue.getMinWait() != 0) {
      queue.setMinWait(newqueue.getMinWait());
    }
    if (newqueue.getTermsId() != null) {
      queue.setTermsId(newqueue.getTermsId());
    }
    if (newqueue.getOwnerId() != null) {
      queue.setOwnerId(newqueue.getOwnerId());
    }
    // Save modification
    getQueueDao().save(queue);
    // TODO REMOVE Log for info
    LOG.info("Queue with id {} updated.", queue.getId());
    // Return modified Queue
    return getBeanMapper().map(queue, QueueEto.class);
  }

  @Override
  public TermsEto modifTerms(long queueid, TermsEto newterms) {

    // Get queue by queue_id
    QueueEntity queue = getQueueByQueueId(queueid);
    // Get terms by terms_id in this queue
    TermsEntity term = getTermsDao().find(queue.getTermsId());
    // Change Description text with new value
    term.setDescription(newterms.getDescription());
    // Save entity
    getTermsDao().save(term);
    // TODO REMOVE Log for info
    LOG.info("Terms for queue {} modified.", queueid, queue.getDescriptionText());
    // Return modified Terms
    return getBeanMapper().map(term, TermsEto.class);
  }

  @Override
  public TermsEto getTermsByQueueId(long queueid) {

    // Get queue queue by queue_id
    QueueEntity queue = getQueueByQueueId(queueid);
    // TODO REMOVE Log terms access
    LOG.info("Get Terms from {} queue.", queueid, queue.getDescriptionText());
    // Return termsEto
    TermsEntity tvalue = queue.getTerms();
    // Return Terms of queue
    return getBeanMapper().map(tvalue, TermsEto.class);
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

    String letter = actCode.getPriority() ? "A" : "Q";
    // TODO REMOVE Log for info
    LOG.info("AccessCode with code '{}{} ' has been created.", letter, actCode.getCode());
    AccessCodeCto cto = new AccessCodeCto();
    cto.setAccessCode(getBeanMapper().map(actCode, AccessCodeEto.class));
    cto.setQueue(getBeanMapper().map(actCode.getQueue(), QueueEto.class));

    return cto;
  }

  // Private methods

  private QueueEntity getQueueByQueueId(long queueid) {

    QueueEntity queue = getQueueDao().find(queueid);
    // TODO Error handle
    if (queue.equals(null)) {
      throw new InternalServerErrorException();
    }
    return queue;
  }

}