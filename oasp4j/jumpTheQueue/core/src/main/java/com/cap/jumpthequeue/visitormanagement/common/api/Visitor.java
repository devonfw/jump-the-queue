package com.cap.jumpthequeue.visitormanagement.common.api;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface Visitor extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getEmail();

  public void setEmail(String email);

  public String getPhone();

  public void setPhone(String phone);

  public Long getCodeId();

  public void setCodeId(Long codeId);

}
