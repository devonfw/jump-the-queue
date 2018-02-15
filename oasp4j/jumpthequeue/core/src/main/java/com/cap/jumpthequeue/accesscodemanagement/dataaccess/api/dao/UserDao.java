package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.UserEntity;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.UserSearchCriteriaTo;
import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for User entities
 */
public interface UserDao extends ApplicationDao<UserEntity> {

  /**
   * Finds the {@link UserEntity users} matching the given {@link UserSearchCriteriaTo}.
   *
   * @param criteria is the {@link UserSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link UserEntity} objects.
   */
  PaginatedListTo<UserEntity> findUsers(UserSearchCriteriaTo criteria);
}
