package com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.TermsEntity;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Terms entities
 */
public interface TermsDao extends ApplicationDao<TermsEntity> {

  /**
   * Finds the {@link TermsEntity termss} matching the given {@link TermsSearchCriteriaTo}.
   *
   * @param criteria is the {@link TermsSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link TermsEntity} objects.
   */
  PaginatedListTo<TermsEntity> findTermss(TermsSearchCriteriaTo criteria);
}
