package com.cap.jumpthequeue.termsmanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.InternalServerErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.QueueDao;
import com.cap.jumpthequeue.termsmanagement.dataaccess.api.TermsEntity;
import com.cap.jumpthequeue.termsmanagement.dataaccess.api.dao.TermsDao;
import com.cap.jumpthequeue.termsmanagement.logic.api.Termsmanagement;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of termsmanagement
 */
@Named
@Transactional
public class TermsmanagementImpl extends AbstractComponentFacade implements Termsmanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(TermsmanagementImpl.class);

  /** @see #getTermsDao() */
  @Inject
  private TermsDao termsDao;

  /** @see #getQueueDao() */
  @Inject
  private QueueDao queueDao;

  /**
   * The constructor.
   */
  public TermsmanagementImpl() {
    super();
  }

  @Override
  public TermsEto findTerms(Long id) {

    LOG.debug("Get Terms with id {} from database.", id);
    return getBeanMapper().map(getTermsDao().findOne(id), TermsEto.class);
  }

  @Override
  public PaginatedListTo<TermsEto> findTermsEtos(TermsSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<TermsEntity> termss = getTermsDao().findTermss(criteria);
    return mapPaginatedEntityList(termss, TermsEto.class);
  }

  @Override
  public boolean deleteTerms(Long termsId) {

    TermsEntity terms = getTermsDao().find(termsId);
    getTermsDao().delete(terms);
    LOG.debug("The terms with id '{}' has been deleted.", termsId);
    return true;
  }

  @Override
  public TermsEto saveTerms(TermsEto terms) {

    Objects.requireNonNull(terms, "terms");
    TermsEntity termsEntity = getBeanMapper().map(terms, TermsEntity.class);

    // initialize, validate termsEntity here if necessary
    TermsEntity resultEntity = getTermsDao().save(termsEntity);
    LOG.debug("Terms with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, TermsEto.class);
  }

  /**
   * Returns the field 'termsDao'.
   *
   * @return the {@link TermsDao} instance.
   */
  public TermsDao getTermsDao() {

    return this.termsDao;
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

  /**
   * @return
   */
  private QueueDao getQueueDao() {

    return this.queueDao;
  }

}