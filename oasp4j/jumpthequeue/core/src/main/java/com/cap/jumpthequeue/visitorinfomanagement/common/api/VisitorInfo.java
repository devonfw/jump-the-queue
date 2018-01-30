package com.cap.jumpthequeue.visitorinfomanagement.common.api;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface VisitorInfo extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getPhone();

  public void setPhone(String phone);

  public String getEmail();

  public void setEmail(String email);

  public Long getQueueId();

  public void setQueueId(Long queueId);

}
