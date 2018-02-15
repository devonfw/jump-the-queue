package com.cap.jumpthequeue.queuemanagement.logic.api;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.TermsEto;

/**
 * Interface for Queuemanagement component.
 */
public interface Queuemanagement {

  /**
   * @param queueid
   * @param newqueue
   * @return
   */
  QueueEto updateQueue(long queueid, QueueEto newqueue);

  /**
   * @param queueid
   * @return
   */
  AccessCodeCto attendQueue(long queueid);

  /**
   * @param queueid
   * @param newterms
   * @return
   */
  TermsEto modifTerms(long queueid, TermsEto newterms);

  /**
   * @param queueid
   * @return
   */
  TermsEto getTermsByQueueId(long queueid);

}