package com.cap.jumpthequeue.visitorinfomanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;

/**
 * Composite transport object of VisitorInfo
 */
public class VisitorInfoCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private VisitorInfoEto visitorInfo;

  private QueueEto queue;

  public VisitorInfoEto getVisitorInfo() {

    return visitorInfo;
  }

  public void setVisitorInfo(VisitorInfoEto visitorInfo) {

    this.visitorInfo = visitorInfo;
  }

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
