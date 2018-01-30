package com.cap.jumpthequeue.ownermanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.ownermanagement.logic.api.Ownermanagement;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;
import com.cap.jumpthequeue.ownermanagement.service.api.rest.OwnermanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Ownermanagement}.
 */
@Named("OwnermanagementRestService")
public class OwnermanagementRestServiceImpl implements OwnermanagementRestService {

  @Inject
  private Ownermanagement ownermanagement;

  @Override
  public OwnerEto getOwner(long id) {

    return this.ownermanagement.findOwner(id);
  }

  @Override
  public OwnerEto saveOwner(OwnerEto owner) {

    return this.ownermanagement.saveOwner(owner);
  }

  @Override
  public void deleteOwner(long id) {

    this.ownermanagement.deleteOwner(id);
  }

  @Override
  public PaginatedListTo<OwnerEto> findOwnersByPost(OwnerSearchCriteriaTo searchCriteriaTo) {

    return this.ownermanagement.findOwnerEtos(searchCriteriaTo);
  }

}