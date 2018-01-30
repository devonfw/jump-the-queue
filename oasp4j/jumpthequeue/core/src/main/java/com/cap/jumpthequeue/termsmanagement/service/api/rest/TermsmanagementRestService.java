package com.cap.jumpthequeue.termsmanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.termsmanagement.logic.api.Termsmanagement;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Termsmanagement}.
 */
@Path("/termsmanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface TermsmanagementRestService {

  /**
   * Delegates to {@link Termsmanagement#findTerms}.
   *
   * @param id the ID of the {@link TermsEto}
   * @return the {@link TermsEto}
   */
  @GET
  @Path("/terms/{id}/")
  public TermsEto getTerms(@PathParam("id") long id);

  /**
   * Delegates to {@link Termsmanagement#getTermsByQueueId}.
   *
   * @param id the ID of the {@link Queue}
   * @return the {@link TermsEto}
   */
  @GET
  @Path("/terms/queue/{queueid}/")
  public TermsEto getTermsByQueueId(@PathParam("queueid") long queueid);

  /**
   * Delegates to {@link Termsmanagement#modifTerms}.
   *
   * @param id the ID of the {@link Queue}
   * @return the {@link TermsEto}
   */
  @PUT
  @Path("/terms/{queue_id}")
  public TermsEto modifTerms(@PathParam("queue_id") long queue_id, TermsEto terms);

  /**
   * Delegates to {@link Termsmanagement#saveTerms}.
   *
   * @param terms the {@link TermsEto} to be saved
   * @return the recently created {@link TermsEto}
   */
  @POST
  @Path("/terms/")
  public TermsEto saveTerms(TermsEto terms);

  /**
   * Delegates to {@link Termsmanagement#deleteTerms}.
   *
   * @param id ID of the {@link TermsEto} to be deleted
   */
  @DELETE
  @Path("/terms/{id}/")
  public void deleteTerms(@PathParam("id") long id);

  /**
   * Delegates to {@link Termsmanagement#findTermsEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding termss.
   * @return the {@link PaginatedListTo list} of matching {@link TermsEto}s.
   */
  @Path("/terms/search")
  @POST
  public PaginatedListTo<TermsEto> findTermssByPost(TermsSearchCriteriaTo searchCriteriaTo);

}