package com.cap.jumpthequeue.accesscodemanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.cap.jumpthequeue.general.common.api.validation.EmailExtended;
import com.cap.jumpthequeue.general.common.api.validation.Phone;
import com.cap.jumpthequeue.general.common.api.validation.Url;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.QueueEntity;
import com.cap.jumpthequeue.usermanagement.common.api.User;

/**
 * @author machamou
 */
@Entity
@Table(name = "User")
public class UserEntity extends ApplicationPersistenceEntity implements User {

  @NotNull
  private String name;

  @NotNull
  @EmailExtended
  private String email;

  @NotNull
  @Phone
  private String phone;

  @NotNull
  @Url
  private String url;

  private String token;

  private String identificator;

  @NotNull
  private Boolean consent;

  private Boolean validated;

  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp creationTime;

  @NotNull
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
   * @return url
   */
  public String getUrl() {

    return this.url;
  }

  /**
   * @param url new value of {@link #geturl}.
   */
  public void setUrl(String url) {

    this.url = url;
  }

  /**
   * @return token
   */
  public String getToken() {

    return this.token;
  }

  /**
   * @param token new value of {@link #gettoken}.
   */
  public void setToken(String token) {

    this.token = token;
  }

  /**
   * @return identificator
   */
  public String getIdentificator() {

    return this.identificator;
  }

  /**
   * @param identificator new value of {@link #getidentificator}.
   */
  public void setIdentificator(String identificator) {

    this.identificator = identificator;
  }

  /**
   * @return consent
   */
  public Boolean getConsent() {

    return this.consent;
  }

  /**
   * @param consent new value of {@link #getconsent}.
   */
  public void setConsent(Boolean consent) {

    this.consent = consent;
  }

  /**
   * @return validated
   */
  public Boolean getValidated() {

    return this.validated;
  }

  /**
   * @param validated new value of {@link #getvalidated}.
   */
  public void setValidated(Boolean validated) {

    this.validated = validated;
  }

  /**
   * @return creationTime
   */
  public Timestamp getCreationTime() {

    return this.creationTime;
  }

  /**
   * @param creationTime new value of {@link #getcreationTime}.
   */
  public void setCreationTime(Timestamp creationTime) {

    this.creationTime = creationTime;
  }

  /**
   * @return queue
   */
  @ManyToOne(fetch = FetchType.EAGER)
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
