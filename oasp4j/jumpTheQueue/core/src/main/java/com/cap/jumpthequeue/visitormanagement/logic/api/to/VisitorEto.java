package com.cap.jumpthequeue.visitormanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.visitormanagement.common.api.Visitor;

/**
 * Entity transport object of Visitor
 */
public class VisitorEto extends AbstractEto implements Visitor {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private Long codeId;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
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
  public String getPhone() {

    return phone;
  }

  @Override
  public void setPhone(String phone) {

    this.phone = phone;
  }

  @Override
  public Long getCodeId() {

    return codeId;
  }

  @Override
  public void setCodeId(Long codeId) {

    this.codeId = codeId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());

    result = prime * result + ((this.codeId == null) ? 0 : this.codeId.hashCode());
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
    VisitorEto other = (VisitorEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.phone == null) {
      if (other.phone != null) {
        return false;
      }
    } else if (!this.phone.equals(other.phone)) {
      return false;
    }

    if (this.codeId == null) {
      if (other.codeId != null) {
        return false;
      }
    } else if (!this.codeId.equals(other.codeId)) {
      return false;
    }
    return true;
  }
}
