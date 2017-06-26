package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for AccessCode entities
 */
public interface AccessCodeDao extends ApplicationDao<AccessCodeEntity> {

  /**
   * Finds the {@link AccessCodeEntity accesscodes} matching the given {@link AccessCodeSearchCriteriaTo}.
   *
   * @param criteria is the {@link AccessCodeSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link AccessCodeEntity} objects.
   */
  PaginatedListTo<AccessCodeEntity> findAccessCodes(AccessCodeSearchCriteriaTo criteria);
}
