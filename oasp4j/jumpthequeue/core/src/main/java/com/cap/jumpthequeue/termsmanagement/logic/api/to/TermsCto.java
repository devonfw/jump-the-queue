package com.cap.jumpthequeue.termsmanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;

/**
 * Composite transport object of Terms
 */
public class TermsCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private TermsEto terms;

  private QueueEto queue;

  public TermsEto getTerms() {

    return this.terms;
  }

  public void setTerms(TermsEto terms) {

    this.terms = terms;
  }

  public QueueEto getQueue() {

    return this.queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
