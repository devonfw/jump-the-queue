package com.cap.jumpthequeue.usermanagement.common.api;

import java.sql.Timestamp;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getEmail();

  public void setEmail(String email);

  public String getPhone();

  public void setPhone(String phone);

  public String getUrl();

  public void setUrl(String url);

  public String getToken();

  public void setToken(String token);

  public String getIdentificator();

  public void setIdentificator(String identificator);

  public Boolean getConsent();

  public void setConsent(Boolean consent);

  public Boolean getValidated();

  public void setValidated(Boolean validated);

  public Timestamp getCreationTime();

  public void setCreationTime(Timestamp creationTime);

  public Long getQueueId();

  public void setQueueId(Long queueId);

}
