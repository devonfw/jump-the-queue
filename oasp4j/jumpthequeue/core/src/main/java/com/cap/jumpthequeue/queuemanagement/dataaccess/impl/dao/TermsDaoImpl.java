package com.cap.jumpthequeue.queuemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.TermsEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.TermsDao;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link TermsDao}.
 */
@Named
public class TermsDaoImpl extends ApplicationDaoImpl<TermsEntity> implements TermsDao {

  /**
   * The constructor.
   */
  public TermsDaoImpl() {

    super();
  }

  @Override
  public Class<TermsEntity> getEntityClass() {

    return TermsEntity.class;
  }

  @Override
  public PaginatedListTo<TermsEntity> findTermss(TermsSearchCriteriaTo criteria) {

    TermsEntity terms = Alias.alias(TermsEntity.class);
    EntityPathBase<TermsEntity> alias = Alias.$(terms);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String description = criteria.getDescription();
    if (description != null) {
      query.where(Alias.$(terms.getDescription()).eq(description));
    }
    Long queue = criteria.getQueueId();
    if (queue != null) {
      if (terms.getQueue() != null) {
        query.where(Alias.$(terms.getQueue().getId()).eq(queue));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}