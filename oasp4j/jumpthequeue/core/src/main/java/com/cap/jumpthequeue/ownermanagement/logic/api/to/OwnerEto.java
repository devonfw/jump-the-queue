package com.cap.jumpthequeue.ownermanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.ownermanagement.common.api.Owner;

/**
 * Entity transport object of Owner
 */
public class OwnerEto extends AbstractEto implements Owner {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String password;

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
  public String getPassword() {

    return password;
  }

  @Override
  public void setPassword(String password) {

    this.password = password;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
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
    OwnerEto other = (OwnerEto) obj;
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
    if (this.password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!this.password.equals(other.password)) {
      return false;
    }
    return true;
  }
}
