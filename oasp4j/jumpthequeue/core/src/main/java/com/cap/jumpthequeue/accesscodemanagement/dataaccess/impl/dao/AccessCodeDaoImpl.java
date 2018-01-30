package com.cap.jumpthequeue.accesscodemanagement.dataaccess.impl.dao;

import java.sql.Timestamp;

import javax.inject.Named;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao.AccessCodeDao;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link AccessCodeDao}.
 */
@Named
public class AccessCodeDaoImpl extends ApplicationDaoImpl<AccessCodeEntity> implements AccessCodeDao {

  /**
   * The constructor.
   */
  public AccessCodeDaoImpl() {

    super();
  }

  @Override
  public Class<AccessCodeEntity> getEntityClass() {

    return AccessCodeEntity.class;
  }

  @Override
  public PaginatedListTo<AccessCodeEntity> findAccessCodes(AccessCodeSearchCriteriaTo criteria) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(accesscode.getName()).eq(name));
    }
    String email = criteria.getEmail();
    if (email != null) {
      query.where(Alias.$(accesscode.getEmail()).eq(email));
    }
    String phone = criteria.getPhone();
    if (phone != null) {
      query.where(Alias.$(accesscode.getPhone()).eq(phone));
    }
    String identificator = criteria.getIdentificator();
    if (identificator != null) {
      query.where(Alias.$(accesscode.getIdentificator()).eq(identificator));
    }
    Integer code = criteria.getCode();
    if (code != null) {
      query.where(Alias.$(accesscode.getCode()).eq(code));
    }
    Boolean priority = criteria.getPriority();
    if (priority != null) {
      query.where(Alias.$(accesscode.getPriority()).eq(priority));
    }
    Timestamp creationTime = criteria.getCreationTime();
    if (creationTime != null) {
      query.where(Alias.$(accesscode.getCreationTime()).eq(creationTime));
    }
    Timestamp startTime = criteria.getStartTime();
    if (startTime != null) {
      query.where(Alias.$(accesscode.getStartTime()).eq(startTime));
    }
    Timestamp endTime = criteria.getEndTime();
    if (endTime != null) {
      query.where(Alias.$(accesscode.getEndTime()).eq(endTime));
    }
    Timestamp estimatedTime = criteria.getEstimatedTime();
    if (estimatedTime != null) {
      query.where(Alias.$(accesscode.getEstimatedTime()).eq(estimatedTime));
    }
    Long queue = criteria.getQueueId();
    if (queue != null) {
      if (accesscode.getQueue() != null) {
        query.where(Alias.$(accesscode.getQueue().getId()).eq(queue));
      }
    }
    return findPaginated(criteria, query, alias);
  }

  @Override
  public PaginatedListTo<AccessCodeEntity> findAttendingAccessCode(AccessCodeSearchCriteriaTo accescodecriteria) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);
    long queueId = accescodecriteria.getQueueId();
    if (queueId != 0 && accesscode.getQueueId() != null) {
      query.where(Alias.$(accesscode.getQueue().getId()).eq(queueId));
    }
    query.where(Alias.$(accesscode.getStartTime()).isNotNull());
    query.where(Alias.$(accesscode.getEndTime()).isNull());

    return findPaginated(accescodecriteria, query, alias);
  }

  @Override
  public AccessCodeEntity findNewAttendAccessCode(long queueId, boolean priority) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    if (queueId != 0 && accesscode.getQueueId() != null) {
      query.where(Alias.$(accesscode.getQueue().getId()).eq(queueId));
    }
    query.where(Alias.$(accesscode.getPriority()).eq(priority));
    query.where(Alias.$(accesscode.getStartTime()).isNull());
    query.where(Alias.$(accesscode.getEndTime()).isNull());

    return query.singleResult(alias);
  }

  @Override
  public PaginatedListTo<AccessCodeEntity> findLastTenAttendedAccessCodesByQueue(
      AccessCodeSearchCriteriaTo accessCodeCriteria) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long queue = accessCodeCriteria.getQueueId();
    if (queue != null) {
      if (accesscode.getQueue() != null) {
        query.where(Alias.$(accesscode.getQueue().getId()).eq(queue));
      }
    }
    query.where(Alias.$(accesscode.getEndTime()).isNotNull()).limit(10);
    return findPaginated(accessCodeCriteria, query, alias);
  }

  @Override
  public Long getAttendedCodesCount(AccessCodeSearchCriteriaTo accessCodeCriteria) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);
    Long queueId = accessCodeCriteria.getQueueId();
    if (queueId != null) {
      if (accesscode.getQueueId() != null) {
        query.where(Alias.$(accesscode.getQueue().getId()).eq(queueId));
      }
    }
    query.where(Alias.$(accesscode.getEndTime()).isNotNull());

    return query.listResults(alias).getTotal();
  }

  @Override
  public Long getNotAttendedCodesCountByTimestamp(AccessCodeSearchCriteriaTo accessCodeCriteria) {

    AccessCodeEntity accesscode = Alias.alias(AccessCodeEntity.class);
    EntityPathBase<AccessCodeEntity> alias = Alias.$(accesscode);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);
    Long queue_id = accessCodeCriteria.getQueueId();
    if (queue_id != null) {
      if (accesscode.getQueueId() != null) {
        query.where(Alias.$(accesscode.getQueue().getId()).eq(queue_id));
      }
    }
    query.where(Alias.$(accesscode.getStartTime()).isNull());

    return query.listResults(alias).getTotal();
  }

}