package com.devonfw.application.jtqj.queuemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.jtqj.queuemanagement.logic.api.Queuemanagement;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.devonfw.application.jtqj.queuemanagement.logic.api.usecase.UcFindQueue;
import com.devonfw.application.jtqj.queuemanagement.logic.api.usecase.UcManageQueue;

/**
 * Implementation of component interface of queuemanagement
 */
@Named
public class QueuemanagementImpl extends AbstractComponentFacade implements Queuemanagement {

	@Inject
	private UcFindQueue ucFindQueue;

	@Inject
	private UcManageQueue ucManageQueue;

	@Override
	public QueueEto findQueue(long id) {

		return this.ucFindQueue.findQueue(id);
	}

	@Override
	public Page<QueueEto> findQueues(QueueSearchCriteriaTo criteria) {
		return this.ucFindQueue.findQueues(criteria);
	}

	@Override
	public QueueEto saveQueue(QueueEto queue) {

		return this.ucManageQueue.saveQueue(queue);
	}

	@Override
	public boolean deleteQueue(long id) {

		return this.ucManageQueue.deleteQueue(id);
	}
}
