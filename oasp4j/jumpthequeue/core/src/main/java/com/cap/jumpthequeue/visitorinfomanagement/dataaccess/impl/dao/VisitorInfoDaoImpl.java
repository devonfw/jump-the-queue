package com.cap.jumpthequeue.visitorinfomanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cap.jumpthequeue.visitorinfomanagement.dataaccess.api.VisitorInfoEntity;
import com.cap.jumpthequeue.visitorinfomanagement.dataaccess.api.dao.VisitorInfoDao;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link VisitorInfoDao}.
 */
@Named
public class VisitorInfoDaoImpl extends ApplicationDaoImpl<VisitorInfoEntity> implements VisitorInfoDao {

  /**
   * The constructor.
   */
  public VisitorInfoDaoImpl() {

    super();
  }

  @Override
  public Class<VisitorInfoEntity> getEntityClass() {

    return VisitorInfoEntity.class;
  }

  @Override
  public PaginatedListTo<VisitorInfoEntity> findVisitorInfos(VisitorInfoSearchCriteriaTo criteria) {

    VisitorInfoEntity visitorinfo = Alias.alias(VisitorInfoEntity.class);
    EntityPathBase<VisitorInfoEntity> alias = Alias.$(visitorinfo);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(visitorinfo.getName()).eq(name));
    }
    String phone = criteria.getPhone();
    if (phone != null) {
      query.where(Alias.$(visitorinfo.getPhone()).eq(phone));
    }
    String email = criteria.getEmail();
    if (email != null) {
      query.where(Alias.$(visitorinfo.getEmail()).eq(email));
    }
    Long queue = criteria.getQueueId();
    if (queue != null) {
      if (visitorinfo.getQueue() != null) {
        query.where(Alias.$(visitorinfo.getQueue().getId()).eq(queue));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}