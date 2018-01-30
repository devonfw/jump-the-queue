package com.cap.jumpthequeue.visitorinfomanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.visitorinfomanagement.common.api.VisitorInfo}s.
 *
 */
public class VisitorInfoSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String phone;

  private String email;

  private Long queueId;

  /**
   * The constructor.
   */
  public VisitorInfoSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getPhone() {

    return phone;
  }

  public void setPhone(String phone) {

    this.phone = phone;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public Long getQueueId() {

    return queueId;
  }

  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

}
