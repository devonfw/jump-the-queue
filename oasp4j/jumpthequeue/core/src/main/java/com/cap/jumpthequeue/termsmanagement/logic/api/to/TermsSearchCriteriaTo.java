package com.cap.jumpthequeue.termsmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.termsmanagement.common.api.Terms}s.
 *
 */
public class TermsSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String description;

  private Long queueId;

  /**
   * The constructor.
   */
  public TermsSearchCriteriaTo() {

    super();
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  public Long getQueueId() {

    return queueId;
  }

  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

}
