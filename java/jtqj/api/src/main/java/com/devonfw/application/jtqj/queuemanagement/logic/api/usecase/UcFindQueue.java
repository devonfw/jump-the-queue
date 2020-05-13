package com.devonfw.application.jtqj.queuemanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueSearchCriteriaTo;

public interface UcFindQueue {

	/**
	 * Returns a Queue by its id 'id'.
	 *
	 * @param id The id 'id' of the Queue.
	 * @return The {@link QueueEto} with id 'id'
	 */
	QueueEto findQueue(long id);

	/**
	 * Returns a paginated list of Queues matching the search criteria.
	 *
	 * @param criteria the {@link QueueSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link QueueEto}s.
	 */
	Page<QueueEto> findQueues(QueueSearchCriteriaTo criteria);

}
