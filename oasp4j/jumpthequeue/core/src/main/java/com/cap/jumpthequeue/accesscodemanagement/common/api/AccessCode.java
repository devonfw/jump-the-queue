package com.cap.jumpthequeue.accesscodemanagement.common.api;

import java.sql.Timestamp;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface AccessCode extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getEmail();

  public void setEmail(String email);

  public String getPhone();

  public void setPhone(String phone);

  public String getIdentificator();

  public void setIdentificator(String identificator);

  public Integer getCode();

  public void setCode(Integer code);

  public Boolean getPriority();

  public void setPriority(Boolean priority);

  public Timestamp getCreationTime();

  public void setCreationTime(Timestamp creationTime);

  public Timestamp getStartTime();

  public void setStartTime(Timestamp startTime);

  public Timestamp getEndTime();

  public void setEndTime(Timestamp endTime);

  public Timestamp getEstimatedTime();

  public void setEstimatedTime(Timestamp estimatedTime);

  public Long getQueueId();

  public void setQueueId(Long queueId);

}
