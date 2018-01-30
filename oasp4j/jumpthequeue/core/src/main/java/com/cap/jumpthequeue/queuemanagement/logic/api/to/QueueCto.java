package com.cap.jumpthequeue.queuemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;

/**
 * Composite transport object of Queue
 */
public class QueueCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private QueueEto queue;

  private TermsEto terms;

  private OwnerEto owner;

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

  public TermsEto getTerms() {

    return terms;
  }

  public void setTerms(TermsEto terms) {

    this.terms = terms;
  }

  public OwnerEto getOwner() {

    return owner;
  }

  public void setOwner(OwnerEto owner) {

    this.owner = owner;
  }

}
