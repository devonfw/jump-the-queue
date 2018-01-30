package com.cap.jumpthequeue.ownermanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.ownermanagement.common.api.Owner;

/**
 * @author machamou
 */
@Entity
@Table(name = "Owner")
public class OwnerEntity extends ApplicationPersistenceEntity implements Owner {

  private String name;

  private String email;

  private String password;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email new value of {@link #getemail}.
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return password
   */
  public String getPassword() {

    return this.password;
  }

  /**
   * @param password new value of {@link #getpassword}.
   */
  public void setPassword(String password) {

    this.password = password;
  }

}
