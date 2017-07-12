package com.cap.jumpthequeue.visitormanagement.dataaccess.api;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.general.common.api.validation.EmailExtended;
import com.cap.jumpthequeue.general.common.api.validation.Phone;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.visitormanagement.common.api.Visitor;

/**
 * Visitor Entity
 */
@Entity
@Table(name = "Visitor")
public class VisitorEntity extends ApplicationPersistenceEntity implements Visitor {

  @NotNull
  private String name;

  @NotNull
  @EmailExtended
  private String email;

  @NotNull
  @Phone
  private String phone;

  private AccessCodeEntity code;

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
   * @return phone
   */
  public String getPhone() {

    return this.phone;
  }

  /**
   * @param phone new value of {@link #getphone}.
   */
  public void setPhone(String phone) {

    this.phone = phone;
  }

  /**
   * @return code
   */
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "idCode")
  public AccessCodeEntity getCode() {

    return this.code;
  }

  /**
   * @param code new value of {@link #getcode}.
   */
  public void setCode(AccessCodeEntity code) {

    this.code = code;
  }

  @Override
  @Transient
  public Long getCodeId() {

    if (this.code == null) {
      return null;
    }
    return this.code.getId();
  }

  @Override
  public void setCodeId(Long codeId) {

    if (codeId == null) {
      this.code = null;
    } else {
      AccessCodeEntity accessCodeEntity = new AccessCodeEntity();
      accessCodeEntity.setId(codeId);
      this.code = accessCodeEntity;
    }
  }

}
