package com.cap.jumpthequeue.accesscode.common.api;

import java.util.Date;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface AccessCode extends ApplicationEntity {

  public String getCode();

  public void setCode(String code);

  public Date getDateAndTime();

  public void setDateAndTime(Date dateAndTime);

  public Long getVisitorId();

  public void setVisitorId(Long visitorId);

}
