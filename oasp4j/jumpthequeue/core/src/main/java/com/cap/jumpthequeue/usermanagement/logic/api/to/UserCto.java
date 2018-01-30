package com.cap.jumpthequeue.usermanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;

/**
 * Composite transport object of User
 */
public class UserCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private UserEto user;

  private QueueEto queue;

  public UserEto getUser() {

    return user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
