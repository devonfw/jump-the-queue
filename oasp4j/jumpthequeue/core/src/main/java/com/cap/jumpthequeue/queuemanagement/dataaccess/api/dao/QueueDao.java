package com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao;

import com.cap.jumpthequeue.general.dataaccess.api.dao.ApplicationDao;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Queue entities
 */
public interface QueueDao extends ApplicationDao<QueueEntity> {

  /**
   * Finds the {@link QueueEntity queues} matching the given {@link QueueSearchCriteriaTo}.
   *
   * @param criteria is the {@link QueueSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link QueueEntity} objects.
   */
  PaginatedListTo<QueueEntity> findQueues(QueueSearchCriteriaTo criteria);
}
