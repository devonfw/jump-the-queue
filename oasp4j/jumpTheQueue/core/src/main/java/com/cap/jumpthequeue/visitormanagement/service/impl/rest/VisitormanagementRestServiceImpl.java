package com.cap.jumpthequeue.visitormanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.visitormanagement.logic.api.Visitormanagement;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;
import com.cap.jumpthequeue.visitormanagement.service.api.rest.VisitormanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Visitormanagement}.
 */
@Named("VisitormanagementRestService")
public class VisitormanagementRestServiceImpl implements VisitormanagementRestService {

  @Inject
  private Visitormanagement visitormanagement;

  @Override
  public VisitorEto getVisitor(long id) {

    return this.visitormanagement.findVisitor(id);
  }

  @Override
  public VisitorCto saveVisitor(VisitorEto visitor) {

    return this.visitormanagement.saveVisitor(visitor);
  }

  @Override
  public void deleteVisitor(long id) {

    this.visitormanagement.deleteVisitor(id);
  }

  @Override
  public PaginatedListTo<VisitorCto> findVisitorsByPost(VisitorSearchCriteriaTo searchCriteriaTo) {

    return this.visitormanagement.findVisitorCtos(searchCriteriaTo);
  }

  @Override
  public PaginatedListTo<QueueEto> queuedVisitors() {

    return this.visitormanagement.queuedVisitors();
  }

}