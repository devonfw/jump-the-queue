package com.cap.jumpthequeue.ownermanagement.logic.api;

import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Ownermanagement component.
 */
public interface Ownermanagement {

  /**
   * Returns a Owner by its id 'id'.
   *
   * @param id The id 'id' of the Owner.
   * @return The {@link OwnerEto} with id 'id'
   */
  OwnerEto findOwner(Long id);

  /**
   * Returns a paginated list of Owners matching the search criteria.
   *
   * @param criteria the {@link OwnerSearchCriteriaTo}.
   * @return the {@link List} of matching {@link OwnerEto}s.
   */
  PaginatedListTo<OwnerEto> findOwnerEtos(OwnerSearchCriteriaTo criteria);

  /**
   * Deletes a owner from the database by its id 'ownerId'.
   *
   * @param ownerId Id of the owner to delete
   * @return boolean <code>true</code> if the owner can be deleted, <code>false</code> otherwise
   */
  boolean deleteOwner(Long ownerId);

  /**
   * Saves a owner and store it in the database.
   *
   * @param owner the {@link OwnerEto} to create.
   * @return the new {@link OwnerEto} that has been saved with ID and version.
   */
  OwnerEto saveOwner(OwnerEto owner);

}