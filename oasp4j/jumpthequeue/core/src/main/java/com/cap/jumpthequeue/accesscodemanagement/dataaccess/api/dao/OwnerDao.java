package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.OwnerEntity;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.OwnerSearchCriteriaTo;
import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;

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
