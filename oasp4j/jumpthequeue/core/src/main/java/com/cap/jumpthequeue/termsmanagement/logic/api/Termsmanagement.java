package com.cap.jumpthequeue.termsmanagement.logic.api;

import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Termsmanagement component.
 */
public interface Termsmanagement {

  /**
   * Returns a Terms by its id 'id'.
   *
   * @param id The id 'id' of the Terms.
   * @return The {@link TermsEto} with id 'id'
   */
  TermsEto findTerms(Long id);

  /**
   * Returns a paginated list of Termss matching the search criteria.
   *
   * @param criteria the {@link TermsSearchCriteriaTo}.
   * @return the {@link List} of matching {@link TermsEto}s.
   */
  PaginatedListTo<TermsEto> findTermsEtos(TermsSearchCriteriaTo criteria);

  /**
   * Deletes a terms from the database by its id 'termsId'.
   *
   * @param termsId Id of the terms to delete
   * @return boolean <code>true</code> if the terms can be deleted, <code>false</code> otherwise
   */
  boolean deleteTerms(Long termsId);

  /**
   * Saves a terms and store it in the database.
   *
   * @param terms the {@link TermsEto} to create.
   * @return the new {@link TermsEto} that has been saved with ID and version.
   */
  TermsEto saveTerms(TermsEto terms);

  /**
   * @param queueid
   * @return
   */
  TermsEto getTermsByQueueId(long queueid);

  /**
   * @param id
   * @param newterms
   * @return
   */
  TermsEto modifTerms(long id, TermsEto newterms);

}