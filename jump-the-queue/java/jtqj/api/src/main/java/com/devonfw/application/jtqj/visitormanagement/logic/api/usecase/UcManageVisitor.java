package com.devonfw.application.jtqj.visitormanagement.logic.api.usecase;

import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;

/**
 * Interface of UcManageVisitor to centralize documentation and signatures of
 * methods.
 */
public interface UcManageVisitor {

	/**
	 * Deletes a visitor from the database by its id 'visitorId'.
	 *
	 * @param visitorId Id of the visitor to delete
	 * @return boolean <code>true</code> if the visitor can be deleted,
	 *         <code>false</code> otherwise
	 */
	boolean deleteVisitor(long visitorId);

	/**
	 * Saves a visitor and store it in the database.
	 *
	 * @param visitor the {@link VisitorEto} to create.
	 * @return the new {@link VisitorEto} that has been saved with ID and version.
	 */
	VisitorEto saveVisitor(VisitorEto visitor);

}
