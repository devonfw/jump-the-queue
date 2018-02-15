package com.cap.jumpthequeue.queuemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.queuemanagement.service.api.rest.QueuemanagementRestService;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Queuemanagement}.
 */
@Named("QueuemanagementRestService")
public class QueuemanagementRestServiceImpl implements QueuemanagementRestService {

  @Inject
  private Queuemanagement queuemanagement;

  @Override
  public QueueEto updateQueue(long queueId, QueueEto newqueue) {

    return this.queuemanagement.updateQueue(queueId, newqueue);

  }

  @Override
  public AccessCodeCto attendQueue(long queueId) {

    return this.queuemanagement.attendQueue(queueId);

  }

  @Override
  public TermsEto getTermsByQueueId(long queueid) {

    return this.queuemanagement.getTermsByQueueId(queueid);

  }

  @Override
  public TermsEto modifTerms(long id, TermsEto newterms) {

    return this.queuemanagement.modifTerms(id, newterms);

  }
}