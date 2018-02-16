package com.cap.jumpthequeue.accesscodemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.UserEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.VisitorInfoEto;

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
  @Path("/makeaccesscode/{number}/")
  public AccessCodeEto makeAccessCode(@PathParam("number") long number);

  @GET
  @Path("/visitorinfo/{queueid}/")
  public PaginatedListTo<VisitorInfoEto> findVisitorInfoEtosByQueueId(@PathParam("queueid") long queueid);

  /**
   * Delegates to {@link Accescodemanagement#getVisitorAccessCode}.
   *
   * @param token token of the {@link AccessCodeEto} to register
   */
  @GET
  @Path("/user/{token}/")
  public AccessCodeCto getVisitorAccessCode(@PathParam("token") String token);

  /**
   * Delegates to {@link Accescodemanagement#getAttendingAccessCode}.
   *
   * @param id ID of the queue where consult atendend now code
   * @return the {@link AccessCodeEto}
   */
  @POST
  @Path("/code/{queueid}/")
  public AccessCodeCto getAccessCode(@PathParam("queueid") long queueid, UserEto userAskingCode);

}