package com.cap.jumpthequeue.queuemanagement.common.api;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface Terms extends ApplicationEntity {

  public String getDescription();

  public void setDescription(String description);

  public Long getQueueId();

  public void setQueueId(Long queueId);

}
