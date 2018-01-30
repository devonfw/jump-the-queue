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
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;

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
  public AccessCodeCto getAccessCode(@PathParam("id") long id);

  /**
   * Delegates to {@link Accesscodemanagement#findAccessCode}.
   *
   * @param id the ID of the {@link AccessCodeEto}
   * @return the {@link AccessCodeEto}
   */
  @GET
  @Path("/makeaccesscode/{number}/")
  public AccessCodeEto makeAccessCode(@PathParam("number") long number);

  /**
   * Delegates to {@link Accescodemanagement#getVisitorAccessCode}.
   *
   * @param token token of the {@link AccessCodeEto} to register
   */
  @GET
  @Path("/accesscode/visitor/{token}/")
  public AccessCodeCto getVisitorAccessCode(@PathParam("token") String token);

  /**
   * Delegates to {@link Accescodemanagement#getVIPAccessCode}.
   *
   * @param token token of the {@link AccessCodeEto} to register
   * @return the {@link AccessCodeEto}
   */
  @GET
  @Path("/accesscode/vip/{token}/")
  public AccessCodeCto getVIPAccessCode(@PathParam("token") String token);

  /**
   * Delegates to {@link Accescodemanagement#getAttendingAccessCode}.
   *
   * @param id ID of the queue where consult atendend now code
   * @return the {@link AccessCodeEto}
   */
  @GET
  @Path("/accesscode/attending/{queue_id}/")
  public AccessCodeCto getAttendingAccessCode(@PathParam("queue_id") long queue_id);

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
   * Delegates to {@link Accescodemanagement#findExistingAccessCodeEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding accesscodes.
   * @return the {@link AccessCodeCto}.
   */
  @Path("/accesscode/exists")
  @POST
  public AccessCodeCto findExistingAccessCodesByPost(UserSearchCriteriaTo searchCriteriaTo);

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