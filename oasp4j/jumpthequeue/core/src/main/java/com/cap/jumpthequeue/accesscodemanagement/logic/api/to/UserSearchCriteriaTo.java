package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.accesscodemanagement.common.api.User}s.
 *
 */
public class UserSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private String url;

  private String token;

  private String identificator;

  private Boolean consent;

  private Boolean validated;

  private Timestamp creationTime;

  private Long queueId;

  /**
   * The constructor.
   */
  public UserSearchCriteriaTo() {

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

  public String getUrl() {

    return this.url;
  }

  public void setUrl(String url) {

    this.url = url;
  }

  public String getToken() {

    return this.token;
  }

  public void setToken(String token) {

    this.token = token;
  }

  public String getIdentificator() {

    return this.identificator;
  }

  public void setIdentificator(String identificator) {

    this.identificator = identificator;
  }

  public Boolean getConsent() {

    return this.consent;
  }

  public void setConsent(Boolean consent) {

    this.consent = consent;
  }

  public Boolean getValidated() {

    return this.validated;
  }

  public void setValidated(Boolean validated) {

    this.validated = validated;
  }

  public Timestamp getCreationTime() {

    return this.creationTime;
  }

  public void setCreationTime(Timestamp creationTime) {

    this.creationTime = creationTime;
  }

  public Long getQueueId() {

    return this.queueId;
  }

  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

}
