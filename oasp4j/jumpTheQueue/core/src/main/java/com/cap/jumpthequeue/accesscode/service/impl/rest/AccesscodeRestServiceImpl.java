package com.cap.jumpthequeue.accesscode.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.accesscode.logic.api.Accesscode;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.accesscode.service.api.rest.AccesscodeRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Accesscode}.
 */
@Named("AccesscodeRestService")
public class AccesscodeRestServiceImpl implements AccesscodeRestService {

  @Inject
  private Accesscode accesscode;

  @Override
  public AccessCodeEto getAccessCode(long id) {

    return this.accesscode.findAccessCode(id);
  }

  @Override
  public AccessCodeEto saveAccessCode(AccessCodeEto accesscode) {

    return this.accesscode.saveAccessCode(accesscode);
  }

  @Override
  public void deleteAccessCode(long id) {

    this.accesscode.deleteAccessCode(id);
  }

  @Override
  public PaginatedListTo<AccessCodeEto> findAccessCodesByPost(AccessCodeSearchCriteriaTo searchCriteriaTo) {

    return this.accesscode.findAccessCodeEtos(searchCriteriaTo);
  }

}