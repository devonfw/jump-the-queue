package com.cap.jumpthequeue.queuemanagement.logic.api;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsEto;

/**
 * Interface for Queuemanagement component.
 */
public interface Queuemanagement {

  /**
   * @param id
   * @param newqueue
   * @return
   */
  QueueEto updateQueue(long id, QueueEto newqueue);

  /**
   * @param queueId
   * @return
   */
  AccessCodeCto attendQueue(long queueId);

  /**
   * @param queue_id
   * @param newterms
   * @return
   */
  TermsEto modifTerms(long queue_id, TermsEto newterms);

  /**
   * @param queueid
   * @return
   */
  TermsEto getTermsByQueueId(long queueid);

}