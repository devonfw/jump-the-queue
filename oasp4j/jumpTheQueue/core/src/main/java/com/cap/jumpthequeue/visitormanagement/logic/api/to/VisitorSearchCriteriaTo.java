package com.cap.jumpthequeue.visitormanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.visitormanagement.common.api.Visitor}s.
 *
 */
public class VisitorSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private Long codeId;

  /**
   * The constructor.
   */
  public VisitorSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public String getPhone() {

    return phone;
  }

  public void setPhone(String phone) {

    this.phone = phone;
  }

  public Long getCodeId() {

    return codeId;
  }

  public void setCodeId(Long codeId) {

    this.codeId = codeId;
  }

}
