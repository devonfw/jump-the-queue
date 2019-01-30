package com.devonfw.application.jtqj.accesscodemanagement.service.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.accesscodemanagement.logic.api.Accesscodemanagement;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.application.jtqj.queuemanagement.logic.api.Queuemanagement;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;

/**
 * The service interface for REST calls in order to execute the logic of
 * component {@link Accesscodemanagement}.
 */
@Path("/accesscodemanagement/v1")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AccesscodemanagementRestService {

	/**
	 * Delegates to {@link Accesscodemanagement#findAccessCodeCto}.
	 *
	 * @param id the ID of the {@link AccessCodeCto}
	 * @return the {@link AccessCodeCto}
	 */
	@GET
	@Path("/accesscode/cto/{id}/")
	public AccessCodeCto getAccessCodeCto(@PathParam("id") long id);

	/**
	 * Delegates to {@link Accesscodemanagement#findAccessCodeCtos}.
	 *
	 * @param searchCriteriaTo the pagination and search criteria to be used for
	 *                         finding accesscodes.
	 * @return the {@link Page list} of matching {@link AccessCodeCto}s.
	 */
	@Path("/accesscode/cto/search")
	@POST
	public Page<AccessCodeCto> findAccessCodeCtos(AccessCodeSearchCriteriaTo searchCriteriaTo);

	/**
	 * Delegates to {@link Accesscodemanagement#saveAccessCode}.
	 *
	 * @param queue the {@link AccessCodeEto} to be saved
	 * @return the recently created {@link AccessCodeEto}
	 */

	@POST
	@Path("/accesscode/")
	public AccessCodeEto saveAccessCode(AccessCodeEto accessCodeEto);

	/**
	 * Delegates to {@link Accesscodemanagement#deleteAccessCode}.
	 *
	 * @param id ID of the {@link AccessCodeEto} to be deleted
	 */
	@DELETE
	@Path("/accesscode/{id}/")
	public void deleteAccessCode(@PathParam("id") long id);

}