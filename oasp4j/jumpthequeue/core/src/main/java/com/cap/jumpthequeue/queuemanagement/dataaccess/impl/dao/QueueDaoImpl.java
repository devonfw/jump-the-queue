package com.cap.jumpthequeue.queuemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.QueueDao;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link QueueDao}.
 */
@Named
public class QueueDaoImpl extends ApplicationDaoImpl<QueueEntity> implements QueueDao {

  /**
   * The constructor.
   */
  public QueueDaoImpl() {

    super();
  }

  @Override
  public Class<QueueEntity> getEntityClass() {

    return QueueEntity.class;
  }

  @Override
  public PaginatedListTo<QueueEntity> findQueues(QueueSearchCriteriaTo criteria) {

    QueueEntity queue = Alias.alias(QueueEntity.class);
    EntityPathBase<QueueEntity> alias = Alias.$(queue);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String descriptionText = criteria.getDescriptionText();
    if (descriptionText != null) {
      query.where(Alias.$(queue.getDescriptionText()).eq(descriptionText));
    }
    Long minWait = criteria.getMinWait();
    if (minWait != null) {
      query.where(Alias.$(queue.getMinWait()).eq(minWait));
    }
    Long terms = criteria.getTermsId();
    if (terms != null) {
      if (queue.getTerms() != null) {
        query.where(Alias.$(queue.getTerms().getId()).eq(terms));
      }
    }
    Long owner = criteria.getOwnerId();
    if (owner != null) {
      if (queue.getOwner() != null) {
        query.where(Alias.$(queue.getOwner().getId()).eq(owner));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}