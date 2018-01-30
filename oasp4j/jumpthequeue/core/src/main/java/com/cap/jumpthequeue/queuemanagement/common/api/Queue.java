package com.cap.jumpthequeue.queuemanagement.common.api;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface Queue extends ApplicationEntity {

  public String getDescriptionText();

  public void setDescriptionText(String descriptionText);

  public long getMinWait();

  public void setMinWait(long minWait);

  public Long getTermsId();

  public void setTermsId(Long termsId);

  public Long getOwnerId();

  public void setOwnerId(Long ownerId);

}
