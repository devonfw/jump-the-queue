package com.cap.jumpthequeue.accesscodemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.OwnerEntity;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao.OwnerDao;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.OwnerSearchCriteriaTo;
import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link OwnerDao}.
 */
@Named
public class OwnerDaoImpl extends ApplicationDaoImpl<OwnerEntity> implements OwnerDao {

  /**
   * The constructor.
   */
  public OwnerDaoImpl() {

    super();
  }

  @Override
  public Class<OwnerEntity> getEntityClass() {

    return OwnerEntity.class;
  }

  @Override
  public PaginatedListTo<OwnerEntity> findOwners(OwnerSearchCriteriaTo criteria) {

    OwnerEntity owner = Alias.alias(OwnerEntity.class);
    EntityPathBase<OwnerEntity> alias = Alias.$(owner);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(owner.getName()).eq(name));
    }
    String email = criteria.getEmail();
    if (email != null) {
      query.where(Alias.$(owner.getEmail()).eq(email));
    }
    String password = criteria.getPassword();
    if (password != null) {
      query.where(Alias.$(owner.getPassword()).eq(password));
    }
    return findPaginated(criteria, query, alias);
  }

}