package com.cap.jumpthequeue.termsmanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.termsmanagement.common.api.Terms;

/**
 * Entity transport object of Terms
 */
public class TermsEto extends AbstractEto implements Terms {

  private static final long serialVersionUID = 1L;

  private String description;

  private Long queueId;

  @Override
  public String getDescription() {

    return description;
  }

  @Override
  public void setDescription(String description) {

    this.description = description;
  }

  @Override
  public Long getQueueId() {

    return queueId;
  }

  @Override
  public void setQueueId(Long queueId) {

    this.queueId = queueId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());

    result = prime * result + ((this.queueId == null) ? 0 : this.queueId.hashCode());
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
    TermsEto other = (TermsEto) obj;
    if (this.description == null) {
      if (other.description != null) {
        return false;
      }
    } else if (!this.description.equals(other.description)) {
      return false;
    }

    if (this.queueId == null) {
      if (other.queueId != null) {
        return false;
      }
    } else if (!this.queueId.equals(other.queueId)) {
      return false;
    }
    return true;
  }
}
