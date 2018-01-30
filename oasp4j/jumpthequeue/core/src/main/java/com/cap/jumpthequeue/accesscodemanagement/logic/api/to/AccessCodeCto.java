package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;

/**
 * Composite transport object of AccessCode
 */
public class AccessCodeCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private AccessCodeEto accessCode;

  private QueueEto queue;

  public AccessCodeEto getAccessCode() {

    return accessCode;
  }

  public void setAccessCode(AccessCodeEto accessCode) {

    this.accessCode = accessCode;
  }

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
