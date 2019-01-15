package com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase;

import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;

public interface UcManageAccessCode {

	/**
	 * Deletes a accessCode from the database by its id 'accessCodeId'.
	 * Decreases the count of customers of the queue assigned to the access
	 * code by one
	 *
	 * @param accessCodeId Id of the accessCode to delete
	 * @return boolean <code>true</code> if the accesscode can be deleted,
	 *         <code>false</code> otherwise
	 */
	Boolean deleteAccessCode(long accessCodeId);

	/**
	 * Saves a queue and store it in the database.
	 * Increases the count of customers of the queue assigned to the access
	 * code by one
	 *
	 * @param queue the {@link AccessCodeCto} to create.
	 * @return the new {@link AccessCodeEto} that has been saved with ID and version.
	 */
	AccessCodeEto saveAccessCode(AccessCodeEto accessCodeEto);

}
