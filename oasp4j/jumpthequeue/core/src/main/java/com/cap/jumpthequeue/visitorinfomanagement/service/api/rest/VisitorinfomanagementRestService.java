package com.cap.jumpthequeue.visitorinfomanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.visitorinfomanagement.logic.api.Visitorinfomanagement;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoEto;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Visitorinfomanagement}.
 */
@Path("/visitorinfomanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VisitorinfomanagementRestService {

  /**
   * Delegates to {@link Visitorinfomanagement#findVisitorInfo}.
   *
   * @param id the ID of the {@link VisitorInfoEto}
   * @return the {@link VisitorInfoEto}
   */
  @GET
  @Path("/visitorinfo/{id}/")
  public VisitorInfoEto getVisitorInfo(@PathParam("id") long id);

  /**
   * Delegates to {@link Visitorinfomanagement#saveVisitorInfo}.
   *
   * @param visitorinfo the {@link VisitorInfoEto} to be saved
   * @return the recently created {@link VisitorInfoEto}
   */
  @POST
  @Path("/visitorinfo/")
  public VisitorInfoEto saveVisitorInfo(VisitorInfoEto visitorinfo);

  /**
   * Delegates to {@link Visitorinfomanagement#deleteVisitorInfo}.
   *
   * @param id ID of the {@link VisitorInfoEto} to be deleted
   */
  @DELETE
  @Path("/visitorinfo/{id}/")
  public void deleteVisitorInfo(@PathParam("id") long id);

  /**
   * Delegates to {@link Visitorinfomanagement#findVisitorInfoEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding visitorinfos.
   * @return the {@link PaginatedListTo list} of matching {@link VisitorInfoEto}s.
   */
  @Path("/visitorinfo/search")
  @POST
  public PaginatedListTo<VisitorInfoEto> findVisitorInfosByPost(VisitorInfoSearchCriteriaTo searchCriteriaTo);

}