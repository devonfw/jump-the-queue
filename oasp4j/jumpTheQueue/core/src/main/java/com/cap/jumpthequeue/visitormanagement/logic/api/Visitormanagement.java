package com.cap.jumpthequeue.visitormanagement.logic.api;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Visitormanagement component.
 */
public interface Visitormanagement {

  /**
   * Returns a Visitor by its id 'id'.
   *
   * @param id The id 'id' of the Visitor.
   * @return The {@link VisitorEto} with id 'id'
   */
  VisitorEto findVisitor(Long id);

  /**
   * Returns a paginated list of Visitors matching the search criteria.
   *
   * @param criteria the {@link VisitorSearchCriteriaTo}.
   * @return the {@link List} of matching {@link VisitorCto}s.
   */
  PaginatedListTo<VisitorCto> findVisitorCtos(VisitorSearchCriteriaTo criteria);

  /**
   * Deletes a visitor from the database by its id 'visitorId'.
   *
   * @param visitorId Id of the visitor to delete
   * @return boolean <code>true</code> if the visitor can be deleted, <code>false</code> otherwise
   */
  boolean deleteVisitor(Long visitorId);

  /**
   * Saves a visitor and store it in the database.
   *
   * @param visitor the {@link VisitorEto} to create.
   * @return the new {@link VisitorEto} that has been saved with ID and version.
   */
  VisitorEto saveVisitor(VisitorEto visitor);

  /**
   * Registers a visitor and returns the related access code as part of the response
   *
   * @param visitor {@link VisitorEto} to create.
   * @return the new {@link VisitorCto} containing the {@link VisitorEto} that has been saved and the related
   *         {@link AccessCodeEto}
   */
  VisitorCto registerVisitor(VisitorEto visitor);

}