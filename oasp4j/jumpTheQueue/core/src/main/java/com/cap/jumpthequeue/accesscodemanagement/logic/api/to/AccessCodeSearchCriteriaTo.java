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

  private String code;

  private Timestamp dateAndTime;

  private Long visitorId;

  /**
   * The constructor.
   */
  public AccessCodeSearchCriteriaTo() {

    super();
  }

  public String getCode() {

    return this.code;
  }

  public void setCode(String code) {

    this.code = code;
  }

  public Timestamp getDateAndTime() {

    return this.dateAndTime;
  }

  public void setDateAndTime(Timestamp dateAndTime) {

    this.dateAndTime = dateAndTime;
  }

  public Long getVisitorId() {

    return this.visitorId;
  }

  public void setVisitorId(Long visitorId) {

    this.visitorId = visitorId;
  }

}
