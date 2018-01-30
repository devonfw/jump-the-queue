package com.cap.jumpthequeue.usermanagement.logic.api;

import com.cap.jumpthequeue.usermanagement.logic.api.to.UserEto;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Usermanagement component.
 */
public interface Usermanagement {

  /**
   * Returns a User by its id 'id'.
   *
   * @param id The id 'id' of the User.
   * @return The {@link UserEto} with id 'id'
   */
  UserEto findUser(Long id);

  /**
   * Returns a paginated list of Users matching the search criteria.
   *
   * @param criteria the {@link UserSearchCriteriaTo}.
   * @return the {@link List} of matching {@link UserEto}s.
   */
  PaginatedListTo<UserEto> findUserEtos(UserSearchCriteriaTo criteria);

  /**
   * Deletes a user from the database by its id 'userId'.
   *
   * @param userId Id of the user to delete
   * @return boolean <code>true</code> if the user can be deleted, <code>false</code> otherwise
   */
  boolean deleteUser(Long userId);

  /**
   * Saves a user and store it in the database.
   *
   * @param user the {@link UserEto} to create.
   * @return the new {@link UserEto} that has been saved with ID and version.
   */
  UserEto saveUser(UserEto user);

}