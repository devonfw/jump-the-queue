package com.cap.jumpthequeue.accesscodemanagement.logic.api;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.UserEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.UserSearchCriteriaTo;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.VisitorInfoEto;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Interface for Accesscodemanagement component.
 */
public interface Accesscodemanagement {

  /**
   * @param queueid
   * @return
   */
  PaginatedListTo<VisitorInfoEto> findVisitorInfoEtosByQueueId(long queueid);

  /**
   * @param token
   * @return
   */
  AccessCodeCto getVisitorAccessCode(String token);

  /**
   * @param queue_id
   * @return
   */
  AccessCodeCto getAccessCode(long queueid, UserEto userAskingCode);

  /**
   * @param number
   * @return
   */
  AccessCodeEto makeAccessCode(long number);

  /**
   * @param searchCriteriaTo
   * @return
   */
  AccessCodeCto findExistingAccessCodesByPost(UserSearchCriteriaTo searchCriteriaTo);

}