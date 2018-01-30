package com.cap.jumpthequeue.imagemanagement.logic.api.to;

import org.apache.http.entity.ContentType;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.imagemanagement.common.api.Image}s.
 *
 */
public class ImageSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String content;

  private ContentType contentType;

  private String mimeType;

  private Long queueId;

  /**
   * The constructor.
   */
  public ImageSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getContent() {

    return this.content;
  }

  public void setContent(String content) {

    this.content = content;
  }

  public ContentType getContentType() {

    return this.contentType;
  }

  public void setContentType(ContentType contentType) {

    this.contentType = contentType;
  }

  public String getMimeType() {

    return this.mimeType;
  }

  public void setMimeType(String mimeType) {

    this.mimeType = mimeType;
  }

  public Long getQueueId() {

    return this.queueId;
  }

  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

}
