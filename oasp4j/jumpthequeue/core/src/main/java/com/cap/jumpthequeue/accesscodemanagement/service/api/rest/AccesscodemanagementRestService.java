package com.cap.jumpthequeue.accesscodemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Accesscodemanagement}.
 */
@Path("/accesscodemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AccesscodemanagementRestService {

  /**
   * Delegates to {@link Accesscodemanagement#findAccessCode}.
   *
   * @param id the ID of the {@link AccessCodeEto}
   * @return the {@link AccessCodeEto}
   */
  @GET
  @Path("/accesscode/{id}/")
  public AccessCodeEto getAccessCode(@PathParam("id") long id);

  /**
   * Delegates to {@link Accesscodemanagement#saveAccessCode}.
   *
   * @param accesscode the {@link AccessCodeEto} to be saved
   * @return the recently created {@link AccessCodeEto}
   */
  @POST
  @Path("/accesscode/")
  public AccessCodeEto saveAccessCode(AccessCodeEto accesscode);

  /**
   * Delegates to {@link Accesscodemanagement#deleteAccessCode}.
   *
   * @param id ID of the {@link AccessCodeEto} to be deleted
   */
  @DELETE
  @Path("/accesscode/{id}/")
  public void deleteAccessCode(@PathParam("id") long id);

  /**
   * Delegates to {@link Accesscodemanagement#findAccessCodeEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding accesscodes.
   * @return the {@link PaginatedListTo list} of matching {@link AccessCodeEto}s.
   */
  @Path("/accesscode/search")
  @POST
  public PaginatedListTo<AccessCodeEto> findAccessCodesByPost(AccessCodeSearchCriteriaTo searchCriteriaTo);

}