package com.cap.jumpthequeue.queuemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsEto;

/**
 * The service interface for REST calls in order to execute the logic of component {@link Queuemanagement}.
 */
@Path("/queuemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface QueuemanagementRestService {

  /**
   * Delegates to {@link Queuemanagement#updateQueue}.
   *
   * @param id the ID of the {@link Queue}
   * @param newqueue value(s) to modif.
   * @return the {@link QueueEto}
   */
  @PUT
  @Path("/queue/{id}")
  public QueueEto updateQueue(@PathParam("id") long id, QueueEto newqueue);

  /**
   * Delegates to {@link Queuemanagement#attendQueue}.
   *
   * @param id the ID of the {@link Queue}
   * @return the {@link AccessCodeEto}
   **/
  @PUT
  @Path("/queue/attend/{id}/")
  public AccessCodeCto attendQueue(@PathParam("id") long id);

  /**
   * Delegates to {@link Queuemanagement#getTermsByQueueId}.
   *
   * @param id the ID of the {@link Queue}
   * @return the {@link TermsEto}
   */
  @GET
  @Path("/terms/queue/{queueid}/")
  public TermsEto getTermsByQueueId(@PathParam("queueid") long queueid);

  /**
   * Delegates to {@link Queuemanagement#modifTerms}.
   *
   * @param id the ID of the {@link Queue}
   * @return the {@link TermsEto}
   */
  @PUT
  @Path("/terms/{queue_id}")
  public TermsEto modifTerms(@PathParam("queue_id") long queue_id, TermsEto terms);

}