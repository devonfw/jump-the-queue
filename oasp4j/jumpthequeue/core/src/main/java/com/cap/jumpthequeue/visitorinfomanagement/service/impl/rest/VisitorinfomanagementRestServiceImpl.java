package com.cap.jumpthequeue.visitorinfomanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.visitorinfomanagement.logic.api.Visitorinfomanagement;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoEto;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;
import com.cap.jumpthequeue.visitorinfomanagement.service.api.rest.VisitorinfomanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Visitorinfomanagement}.
 */
@Named("VisitorinfomanagementRestService")
public class VisitorinfomanagementRestServiceImpl implements VisitorinfomanagementRestService {

  @Inject
  private Visitorinfomanagement visitorinfomanagement;

  @Override
  public VisitorInfoEto getVisitorInfo(long id) {

    return this.visitorinfomanagement.findVisitorInfo(id);
  }

  @Override
  public VisitorInfoEto saveVisitorInfo(VisitorInfoEto visitorinfo) {

    return this.visitorinfomanagement.saveVisitorInfo(visitorinfo);
  }

  @Override
  public void deleteVisitorInfo(long id) {

    this.visitorinfomanagement.deleteVisitorInfo(id);
  }

  @Override
  public PaginatedListTo<VisitorInfoEto> findVisitorInfosByPost(VisitorInfoSearchCriteriaTo searchCriteriaTo) {

    return this.visitorinfomanagement.findVisitorInfoEtos(searchCriteriaTo);
  }

}