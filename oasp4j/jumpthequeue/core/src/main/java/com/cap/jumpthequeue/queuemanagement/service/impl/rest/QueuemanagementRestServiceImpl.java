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

  // Update Queue info
  @Override
  public QueueEto updateQueue(long queueId, QueueEto newqueueinfo) {

    return this.queuemanagement.updateQueue(queueId, newqueueinfo);
  }

  // Update AccessCodes status for one queue = next turn
  @Override
  public AccessCodeCto attendQueue(long queueid) {

    return this.queuemanagement.attendQueue(queueid);
  }

  @Override
  public TermsEto getTermsByQueueId(long queueid) {

    return this.queuemanagement.getTermsByQueueId(queueid);

  }

  @Override
  public TermsEto modifTerms(long queueid, TermsEto newterms) {

    return this.queuemanagement.modifTerms(queueid, newterms);

  }
}