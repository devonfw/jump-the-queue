package com.cap.jumpthequeue.queuemanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.cap.jumpthequeue.queuemanagement.common.api.Queue}s.
 *
 */
public class QueueSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String descriptionText;

  private Long minWait;

  private Long termsId;

  private Long ownerId;

  /**
   * The constructor.
   */
  public QueueSearchCriteriaTo() {

    super();
  }

  public String getDescriptionText() {

    return descriptionText;
  }

  public void setDescriptionText(String descriptionText) {

    this.descriptionText = descriptionText;
  }

  public Long getMinWait() {

    return minWait;
  }

  public void setMinWait(Long minWait) {

    this.minWait = minWait;
  }

  public Long getTermsId() {

    return termsId;
  }

  public void setTermsId(Long termsId) {

    this.termsId = termsId;
  }

  public Long getOwnerId() {

    return ownerId;
  }

  public void setOwnerId(Long ownerId) {

    this.ownerId = ownerId;
  }

}
