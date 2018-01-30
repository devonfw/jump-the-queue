package com.cap.jumpthequeue.imagemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.http.entity.ContentType;

import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.imagemanagement.common.api.Image;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;

/**
 * @author machamou
 */
@Entity
@Table(name = "Image")
public class ImageEntity extends ApplicationPersistenceEntity implements Image {

  private String name;

  private String content;

  private ContentType contentType;

  private String mimeType;

  private QueueEntity queue;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return content
   */
  public String getContent() {

    return this.content;
  }

  /**
   * @param content new value of {@link #getcontent}.
   */
  public void setContent(String content) {

    this.content = content;
  }

  /**
   * @return contentType
   */
  public ContentType getContentType() {

    return this.contentType;
  }

  /**
   * @param contentType new value of {@link #getcontentType}.
   */
  public void setContentType(ContentType contentType) {

    this.contentType = contentType;
  }

  /**
   * @return mimeType
   */
  public String getMimeType() {

    return this.mimeType;
  }

  /**
   * @param mimeType new value of {@link #getmimeType}.
   */
  public void setMimeType(String mimeType) {

    this.mimeType = mimeType;
  }

  /**
   * @return queue
   */
  @OneToOne
  @JoinColumn(name = "idQueue")
  public QueueEntity getQueue() {

    return this.queue;
  }

  /**
   * @param queue new value of {@link #getqueue}.
   */
  public void setQueue(QueueEntity queue) {

    this.queue = queue;
  }

  @Override
  @Transient
  public Long getQueueId() {

    if (this.queue == null) {
      return null;
    }
    return this.queue.getId();
  }

  @Override
  public void setQueueId(Long queueId) {

    if (queueId == null) {
      this.queue = null;
    } else {
      QueueEntity queueEntity = new QueueEntity();
      queueEntity.setId(queueId);
      this.queue = queueEntity;
    }
  }

}
