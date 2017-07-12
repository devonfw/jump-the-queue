package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import com.cap.jumpthequeue.accesscodemanagement.common.api.AccessCode;
import com.cap.jumpthequeue.general.common.api.to.AbstractEto;

/**
 * Entity transport object of AccessCode
 */
public class AccessCodeEto extends AbstractEto implements AccessCode {

  private static final long serialVersionUID = 1L;

  private String code;

  private Timestamp dateAndTime;

  private Long visitorId;

  @Override
  public String getCode() {

    return this.code;
  }

  @Override
  public void setCode(String code) {

    this.code = code;
  }

  @Override
  public Timestamp getDateAndTime() {

    return this.dateAndTime;
  }

  @Override
  public void setDateAndTime(Timestamp dateAndTime) {

    this.dateAndTime = dateAndTime;
  }

  @Override
  public Long getVisitorId() {

    return this.visitorId;
  }

  @Override
  public void setVisitorId(Long visitorId) {

    this.visitorId = visitorId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
    result = prime * result + ((this.dateAndTime == null) ? 0 : this.dateAndTime.hashCode());

    result = prime * result + ((this.visitorId == null) ? 0 : this.visitorId.hashCode());
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
    AccessCodeEto other = (AccessCodeEto) obj;
    if (this.code == null) {
      if (other.code != null) {
        return false;
      }
    } else if (!this.code.equals(other.code)) {
      return false;
    }
    if (this.dateAndTime == null) {
      if (other.dateAndTime != null) {
        return false;
      }
    } else if (!this.dateAndTime.equals(other.dateAndTime)) {
      return false;
    }

    if (this.visitorId == null) {
      if (other.visitorId != null) {
        return false;
      }
    } else if (!this.visitorId.equals(other.visitorId)) {
      return false;
    }
    return true;
  }
}
