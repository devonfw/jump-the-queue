package com.cap.jumpthequeue.ownermanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.ownermanagement.logic.api.Ownermanagement;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Ownermanagement}.
 */
@Path("/ownermanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface OwnermanagementRestService {

  /**
   * Delegates to {@link Ownermanagement#findOwner}.
   *
   * @param id the ID of the {@link OwnerEto}
   * @return the {@link OwnerEto}
   */
  @GET
  @Path("/owner/{id}/")
  public OwnerEto getOwner(@PathParam("id") long id);

  /**
   * Delegates to {@link Ownermanagement#saveOwner}.
   *
   * @param owner the {@link OwnerEto} to be saved
   * @return the recently created {@link OwnerEto}
   */
  @POST
  @Path("/owner/")
  public OwnerEto saveOwner(OwnerEto owner);

  /**
   * Delegates to {@link Ownermanagement#deleteOwner}.
   *
   * @param id ID of the {@link OwnerEto} to be deleted
   */
  @DELETE
  @Path("/owner/{id}/")
  public void deleteOwner(@PathParam("id") long id);

  /**
   * Delegates to {@link Ownermanagement#findOwnerEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding owners.
   * @return the {@link PaginatedListTo list} of matching {@link OwnerEto}s.
   */
  @Path("/owner/search")
  @POST
  public PaginatedListTo<OwnerEto> findOwnersByPost(OwnerSearchCriteriaTo searchCriteriaTo);

}