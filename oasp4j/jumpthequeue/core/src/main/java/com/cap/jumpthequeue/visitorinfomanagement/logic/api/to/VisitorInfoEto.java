package com.cap.jumpthequeue.visitorinfomanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.visitorinfomanagement.common.api.VisitorInfo;

/**
 * Entity transport object of VisitorInfo
 */
public class VisitorInfoEto extends AbstractEto implements VisitorInfo {

  private static final long serialVersionUID = 1L;

  private String name;

  private String phone;

  private String email;

  private Long queueId;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getPhone() {

    return phone;
  }

  @Override
  public void setPhone(String phone) {

    this.phone = phone;
  }

  @Override
  public String getEmail() {

    return email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;
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
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());

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
    VisitorInfoEto other = (VisitorInfoEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.phone == null) {
      if (other.phone != null) {
        return false;
      }
    } else if (!this.phone.equals(other.phone)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
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
