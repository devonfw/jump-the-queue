package com.cap.jumpthequeue.queuemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.queuemanagement.common.api.Queue;

/**
 * Entity transport object of Queue
 */
public class QueueEto extends AbstractEto implements Queue {

  private static final long serialVersionUID = 1L;

  private String descriptionText;

  private long minWait;

  private Long termsId;

  private Long ownerId;

  @Override
  public String getDescriptionText() {

    return descriptionText;
  }

  @Override
  public void setDescriptionText(String descriptionText) {

    this.descriptionText = descriptionText;
  }

  @Override
  public long getMinWait() {

    return minWait;
  }

  @Override
  public void setMinWait(long minWait) {

    this.minWait = minWait;
  }

  @Override
  public Long getTermsId() {

    return termsId;
  }

  @Override
  public void setTermsId(Long termsId) {

    this.termsId = termsId;
  }

  @Override
  public Long getOwnerId() {

    return ownerId;
  }

  @Override
  public void setOwnerId(Long ownerId) {

    this.ownerId = ownerId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.descriptionText == null) ? 0 : this.descriptionText.hashCode());
    result = prime * result + ((Long) minWait).hashCode();

    result = prime * result + ((this.termsId == null) ? 0 : this.termsId.hashCode());

    result = prime * result + ((this.ownerId == null) ? 0 : this.ownerId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    QueueEto other = (QueueEto) obj;
    if (this.descriptionText == null) {
      if (other.descriptionText != null) {
        return false;
      }
    } else if (!this.descriptionText.equals(other.descriptionText)) {
      return false;
    }
    if (this.minWait != other.minWait) {
      return false;
    }

    if (this.termsId == null) {
      if (other.termsId != null) {
        return false;
      }
    } else if (!this.termsId.equals(other.termsId)) {
      return false;
    }

    if (this.ownerId == null) {
      if (other.ownerId != null) {
        return false;
      }
    } else if (!this.ownerId.equals(other.ownerId)) {
      return false;
    }
    return true;
  }
}
