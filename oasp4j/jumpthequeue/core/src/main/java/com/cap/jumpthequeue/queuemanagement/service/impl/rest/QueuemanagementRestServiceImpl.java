package com.cap.jumpthequeue.queuemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.cap.jumpthequeue.queuemanagement.service.api.rest.QueuemanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Queuemanagement}.
 */
@Named("QueuemanagementRestService")
public class QueuemanagementRestServiceImpl implements QueuemanagementRestService {

  @Inject
  private Queuemanagement queuemanagement;

  @Override
  public QueueEto getQueue(long id) {

    return this.queuemanagement.findQueue(id);
  }

  @Override
  public QueueEto saveQueue(QueueEto queue) {

    return this.queuemanagement.saveQueue(queue);
  }

  @Override
  public void deleteQueue(long id) {

    this.queuemanagement.deleteQueue(id);
  }

  @Override
  public PaginatedListTo<QueueEto> findQueuesByPost(QueueSearchCriteriaTo searchCriteriaTo) {

    return this.queuemanagement.findQueueEtos(searchCriteriaTo);
  }

  @Override
  public QueueEto updateQueue(long queueId, QueueEto newqueue) {

    return this.queuemanagement.updateQueue(queueId, newqueue);

  }

  @Override
  public AccessCodeCto attendQueue(long queueId) {

    return this.queuemanagement.attendQueue(queueId);

  }

}