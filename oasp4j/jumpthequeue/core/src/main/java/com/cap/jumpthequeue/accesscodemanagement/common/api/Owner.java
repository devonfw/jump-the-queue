package com.cap.jumpthequeue.accesscodemanagement.common.api;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface Owner extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getEmail();

  public void setEmail(String email);

  public String getPassword();

  public void setPassword(String password);

}
