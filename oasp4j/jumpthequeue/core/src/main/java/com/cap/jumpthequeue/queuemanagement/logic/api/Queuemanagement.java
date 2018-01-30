package com.cap.jumpthequeue.queuemanagement.logic.api;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Queuemanagement component.
 */
public interface Queuemanagement {

  /**
   * Returns a Queue by its id 'id'.
   *
   * @param id The id 'id' of the Queue.
   * @return The {@link QueueEto} with id 'id'
   */
  QueueEto findQueue(Long id);

  /**
   * Returns a paginated list of Queues matching the search criteria.
   *
   * @param criteria the {@link QueueSearchCriteriaTo}.
   * @return the {@link List} of matching {@link QueueEto}s.
   */
  PaginatedListTo<QueueEto> findQueueEtos(QueueSearchCriteriaTo criteria);

  /**
   * Deletes a queue from the database by its id 'queueId'.
   *
   * @param queueId Id of the queue to delete
   * @return boolean <code>true</code> if the queue can be deleted, <code>false</code> otherwise
   */
  boolean deleteQueue(Long queueId);

  /**
   * Saves a queue and store it in the database.
   *
   * @param queue the {@link QueueEto} to create.
   * @return the new {@link QueueEto} that has been saved with ID and version.
   */
  QueueEto saveQueue(QueueEto queue);

  /**
   * @param id
   * @param newqueue
   * @return
   */
  QueueEto updateQueue(long id, QueueEto newqueue);

  /**
   * @param queueId
   * @return
   */
  AccessCodeCto attendQueue(long queueId);

}