package com.cap.jumpthequeue.visitorinfomanagement.logic.api;

import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoEto;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Visitorinfomanagement component.
 */
public interface Visitorinfomanagement {

  /**
   * Returns a VisitorInfo by its id 'id'.
   *
   * @param id The id 'id' of the VisitorInfo.
   * @return The {@link VisitorInfoEto} with id 'id'
   */
  VisitorInfoEto findVisitorInfo(Long id);

  /**
   * Returns a paginated list of VisitorInfos matching the search criteria.
   *
   * @param criteria the {@link VisitorInfoSearchCriteriaTo}.
   * @return the {@link List} of matching {@link VisitorInfoEto}s.
   */
  PaginatedListTo<VisitorInfoEto> findVisitorInfoEtos(VisitorInfoSearchCriteriaTo criteria);

  /**
   * Deletes a visitorInfo from the database by its id 'visitorInfoId'.
   *
   * @param visitorInfoId Id of the visitorInfo to delete
   * @return boolean <code>true</code> if the visitorInfo can be deleted, <code>false</code> otherwise
   */
  boolean deleteVisitorInfo(Long visitorInfoId);

  /**
   * Saves a visitorInfo and store it in the database.
   *
   * @param visitorInfo the {@link VisitorInfoEto} to create.
   * @return the new {@link VisitorInfoEto} that has been saved with ID and version.
   */
  VisitorInfoEto saveVisitorInfo(VisitorInfoEto visitorInfo);

}