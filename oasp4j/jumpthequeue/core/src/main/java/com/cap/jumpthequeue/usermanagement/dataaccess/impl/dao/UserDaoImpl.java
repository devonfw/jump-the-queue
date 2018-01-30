package com.cap.jumpthequeue.usermanagement.dataaccess.impl.dao;

import java.sql.Timestamp;

import javax.inject.Named;

import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cap.jumpthequeue.usermanagement.dataaccess.api.UserEntity;
import com.cap.jumpthequeue.usermanagement.dataaccess.api.dao.UserDao;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link UserDao}.
 */
@Named
public class UserDaoImpl extends ApplicationDaoImpl<UserEntity> implements UserDao {

  /**
   * The constructor.
   */
  public UserDaoImpl() {

    super();
  }

  @Override
  public Class<UserEntity> getEntityClass() {

    return UserEntity.class;
  }

  @Override
  public PaginatedListTo<UserEntity> findUsers(UserSearchCriteriaTo criteria) {

    UserEntity user = Alias.alias(UserEntity.class);
    EntityPathBase<UserEntity> alias = Alias.$(user);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(user.getName()).eq(name));
    }
    String email = criteria.getEmail();
    if (email != null) {
      query.where(Alias.$(user.getEmail()).eq(email));
    }
    String phone = criteria.getPhone();
    if (phone != null) {
      query.where(Alias.$(user.getPhone()).eq(phone));
    }
    String url = criteria.getUrl();
    if (url != null) {
      query.where(Alias.$(user.getUrl()).eq(url));
    }
    String token = criteria.getToken();
    if (token != null) {
      query.where(Alias.$(user.getToken()).eq(token));
    }
    String identificator = criteria.getIdentificator();
    if (identificator != null) {
      query.where(Alias.$(user.getIdentificator()).eq(identificator));
    }
    Boolean consent = criteria.getConsent();
    if (consent != null) {
      query.where(Alias.$(user.getConsent()).eq(consent));
    }
    Boolean validated = criteria.getValidated();
    if (validated != null) {
      query.where(Alias.$(user.getValidated()).eq(validated));
    }
    Timestamp creationTime = criteria.getCreationTime();
    if (creationTime != null) {
      query.where(Alias.$(user.getCreationTime()).eq(creationTime));
    }
    Long queue = criteria.getQueueId();
    if (queue != null) {
      if (user.getQueue() != null) {
        query.where(Alias.$(user.getQueue().getId()).eq(queue));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}