package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.visitorinfomanagement.common.api.VisitorInfo;

/**
 * @author machamou
 */
@Entity
@Table(name = "VisitorInfo")
public class VisitorInfoEntity extends ApplicationPersistenceEntity implements VisitorInfo {

  private String name;

  private String phone;

  private String email;

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
   * @return phone
   */
  public String getPhone() {

    return this.phone;
  }

  /**
   * @param phone new value of {@link #getphone}.
   */
  public void setPhone(String phone) {

    this.phone = phone;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return queue
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "queue_id")
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
