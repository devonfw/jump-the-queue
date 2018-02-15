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

  @Override
  public TermsEto modifTerms(long queue_id, TermsEto newterms) {

    // Get queue by queue_id
    QueueEntity queue = getQueueDao().find(queue_id);
    if (queue.equals(null)) {
      throw new InternalServerErrorException();
    }
    // Get terms by terms_id in this queue
    TermsEntity term = getTermsDao().find(queue.getTermsId());

    // Change Description text with new value
    term.setDescription(newterms.getDescription());

    // Save entity
    getTermsDao().save(term);

    // Log for info
    LOG.info("Terms for queue {} modified.", queue_id, queue.getDescriptionText());

    // Return modified Terms
    return getBeanMapper().map(term, TermsEto.class);
  }

  @Override
  public TermsEto getTermsByQueueId(long queueid) {

    // Get queue
    QueueEntity queue = getQueueDao().find(queueid);

    if (queue.equals(null)) {
      throw new InternalServerErrorException();
    }
    // Log terms access
    LOG.info("Get Terms from {} queue.", queueid, queue.getDescriptionText());

    // Return termsEto

    TermsEntity tvalue = queue.getTerms();
    return getBeanMapper().map(tvalue, TermsEto.class);
  }

}