package com.cap.jumpthequeue.queuemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Terms
 */
public class TermsCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private TermsEto terms;

  private QueueEto queue;

  public TermsEto getTerms() {

    return terms;
  }

  public void setTerms(TermsEto terms) {

    this.terms = terms;
  }

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
