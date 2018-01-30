package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.accesscodemanagement.common.api.AccessCode}s.
 *
 */
public class AccessCodeSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private String identificator;

  private Integer code;

  private Boolean priority;

  private Timestamp creationTime;

  private Timestamp startTime;

  private Timestamp endTime;

  private Timestamp estimatedTime;

  private Long queueId;

  /**
   * The constructor.
   */
  public AccessCodeSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getEmail() {

    return this.email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public String getPhone() {

    return this.phone;
  }

  public void setPhone(String phone) {

    this.phone = phone;
  }

  public String getIdentificator() {

    return this.identificator;
  }

  public void setIdentificator(String identificator) {

    this.identificator = identificator;
  }

  public Integer getCode() {

    return this.code;
  }

  public void setCode(Integer code) {

    this.code = code;
  }

  public Boolean getPriority() {

    return this.priority;
  }

  public void setPriority(Boolean priority) {

    this.priority = priority;
  }

  public Timestamp getCreationTime() {

    return this.creationTime;
  }

  public void setCreationTime(Timestamp creationTime) {

    this.creationTime = creationTime;
  }

  public Timestamp getStartTime() {

    return this.startTime;
  }

  public void setStartTime(Timestamp startTime) {

    this.startTime = startTime;
  }

  public Timestamp getEndTime() {

    return this.endTime;
  }

  public void setEndTime(Timestamp endTime) {

    this.endTime = endTime;
  }

  public Timestamp getEstimatedTime() {

    return this.estimatedTime;
  }

  public void setEstimatedTime(Timestamp estimatedTime) {

    this.estimatedTime = estimatedTime;
  }

  public Long getQueueId() {

    return this.queueId;
  }

  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

}
