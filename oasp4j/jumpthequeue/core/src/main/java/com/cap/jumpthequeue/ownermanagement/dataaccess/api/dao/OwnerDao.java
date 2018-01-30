package com.cap.jumpthequeue.ownermanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;
import com.cap.jumpthequeue.ownermanagement.dataaccess.api.OwnerEntity;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Owner entities
 */
public interface OwnerDao extends ApplicationDao<OwnerEntity> {

  /**
   * Finds the {@link OwnerEntity owners} matching the given {@link OwnerSearchCriteriaTo}.
   *
   * @param criteria is the {@link OwnerSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link OwnerEntity} objects.
   */
  PaginatedListTo<OwnerEntity> findOwners(OwnerSearchCriteriaTo criteria);
}
