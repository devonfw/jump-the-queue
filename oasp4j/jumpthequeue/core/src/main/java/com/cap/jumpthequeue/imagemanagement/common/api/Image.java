package com.cap.jumpthequeue.imagemanagement.common.api;

import org.apache.http.entity.ContentType;

import com.cap.jumpthequeue.general.common.api.ApplicationEntity;

public interface Image extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getContent();

  public void setContent(String content);

  public ContentType getContentType();

  public void setContentType(ContentType contentType);

  public String getMimeType();

  public void setMimeType(String mimeType);

  public Long getQueueId();

  public void setQueueId(Long queueId);

}
