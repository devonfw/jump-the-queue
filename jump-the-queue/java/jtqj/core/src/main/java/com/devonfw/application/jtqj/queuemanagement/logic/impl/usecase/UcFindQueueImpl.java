package com.devonfw.application.jtqj.queuemanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.devonfw.application.jtqj.queuemanagement.logic.api.usecase.UcFindQueue;
import com.devonfw.application.jtqj.queuemanagement.logic.base.usecase.AbstractQueueUc;

/**
 * Use case implementation for searching, filtering and getting Queues
 */
@Named
@Validated
@Transactional
public class UcFindQueueImpl extends AbstractQueueUc implements UcFindQueue {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindQueueImpl.class);

	@Override
	public QueueEto findQueue(long id) {
		LOG.debug("Get Queue with id {} from database.", id);
		Optional<QueueEntity> foundEntity = getQueueRepository().findById(id);
		if (foundEntity.isPresent())
			return getBeanMapper().map(foundEntity.get(), QueueEto.class);
		else
			return null;
	}

	@Override
	public Page<QueueEto> findQueues(QueueSearchCriteriaTo criteria) {
		Page<QueueEntity> queues = getQueueRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(queues, QueueEto.class);
	}

}
