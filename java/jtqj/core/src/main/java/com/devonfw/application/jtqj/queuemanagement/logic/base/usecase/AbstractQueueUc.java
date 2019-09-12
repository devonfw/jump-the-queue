package com.devonfw.application.jtqj.queuemanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.jtqj.general.logic.base.AbstractUc;
import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.repo.QueueRepository;

/**
 * Abstract use case for Queues, which provides access to the commonly necessary
 * data access objects.
 */
public class AbstractQueueUc extends AbstractUc {

	/** @see #getQueueRepository() */
	@Inject
	private QueueRepository queueRepository;

	/**
	 * Returns the field 'queueRepository'.
	 * 
	 * @return the {@link QueueRepository} instance.
	 */
	public QueueRepository getQueueRepository() {

		return this.queueRepository;
	}

}
