package com.cap.jumpthequeue.accesscode.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.accesscode.logic.api.Accesscode;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Accesscode}.
 */
@Path("/accesscode/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AccesscodeRestService {

  /**
   * Delegates to {@link Accesscode#findAccessCode}.
   *
   * @param id the ID of the {@link AccessCodeEto}
   * @return the {@link AccessCodeEto}
   */
  @GET
  @Path("/accesscode/{id}/")
  public AccessCodeEto getAccessCode(@PathParam("id") long id);

  /**
   * Delegates to {@link Accesscode#saveAccessCode}.
   *
   * @param accesscode the {@link AccessCodeEto} to be saved
   * @return the recently created {@link AccessCodeEto}
   */
  @POST
  @Path("/accesscode/")
  public AccessCodeEto saveAccessCode(AccessCodeEto accesscode);

  /**
   * Delegates to {@link Accesscode#deleteAccessCode}.
   *
   * @param id ID of the {@link AccessCodeEto} to be deleted
   */
  @DELETE
  @Path("/accesscode/{id}/")
  public void deleteAccessCode(@PathParam("id") long id);

  /**
   * Delegates to {@link Accesscode#findAccessCodeEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding accesscodes.
   * @return the {@link PaginatedListTo list} of matching {@link AccessCodeEto}s.
   */
  @Path("/accesscode/search")
  @POST
  public PaginatedListTo<AccessCodeEto> findAccessCodesByPost(AccessCodeSearchCriteriaTo searchCriteriaTo);

}