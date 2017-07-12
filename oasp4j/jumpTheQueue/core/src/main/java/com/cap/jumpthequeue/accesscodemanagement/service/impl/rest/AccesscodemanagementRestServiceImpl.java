package com.cap.jumpthequeue.accesscodemanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.accesscodemanagement.service.api.rest.AccesscodemanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Accesscodemanagement}.
 */
@Named("AccesscodemanagementRestService")
public class AccesscodemanagementRestServiceImpl implements AccesscodemanagementRestService {

  @Inject
  private Accesscodemanagement accesscodemanagement;

  @Override
  public AccessCodeEto getAccessCode(long id) {

    return this.accesscodemanagement.findAccessCode(id);
  }

  @Override
  public AccessCodeEto saveAccessCode(AccessCodeEto accesscode) {

    return this.accesscodemanagement.saveAccessCode(accesscode);
  }

  @Override
  public void deleteAccessCode(long id) {

    this.accesscodemanagement.deleteAccessCode(id);
  }

  @Override
  public PaginatedListTo<AccessCodeEto> findAccessCodesByPost(AccessCodeSearchCriteriaTo searchCriteriaTo) {

    return this.accesscodemanagement.findAccessCodeEtos(searchCriteriaTo);
  }

}