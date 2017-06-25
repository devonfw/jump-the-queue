package com.cap.jumpthequeue.accesscodemanagement.dataaccess.impl.dao;

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

    String code = criteria.getCode();
    if (code != null) {
      query.where(Alias.$(accesscode.getCode()).eq(code));
    }
    Long visitor = criteria.getVisitorId();
    if (visitor != null) {
      if (accesscode.getVisitor() != null) {
        query.where(Alias.$(accesscode.getVisitor().getId()).eq(visitor));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}