package com.cap.jumpthequeue.accesscode.dataaccess.api;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.cap.jumpthequeue.accesscode.common.api.AccessCode;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.VisitorEntity;

/**
 * @author pparrado
 */
@Entity
@Table(name = "ACCESSCODE")
public class AccessCodeEntity extends ApplicationPersistenceEntity implements AccessCode {

  private String code;

  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAndTime;

  private VisitorEntity visitor;

  private static final long serialVersionUID = 1L;

  /**
   * @return visitor
   */
  @OneToOne
  @JoinColumn(name = "idVisitor")
  public VisitorEntity getVisitor() {

    return this.visitor;
  }

  /**
   * @param visitor new value of {@link #getvisitor}.
   */
  public void setVisitor(VisitorEntity visitor) {

    this.visitor = visitor;
  }

  /**
   * @return code
   */
  public String getCode() {

    return this.code;
  }

  /**
   * @param code new value of {@link #getcode}.
   */
  public void setCode(String code) {

    this.code = code;
  }

  /**
   * @return dateAndTime
   */
  public Date getDateAndTime() {

    return this.dateAndTime;
  }

  /**
   * @param dateAndTime new value of {@link #getdateAndTime}.
   */
  public void setDateAndTime(Date dateAndTime) {

    this.dateAndTime = dateAndTime;
  }

  @Override
  @Transient
  public Long getVisitorId() {

    if (this.visitor == null) {
      return null;
    }
    return this.visitor.getId();
  }

  @Override
  public void setVisitorId(Long visitorId) {

    if (visitorId == null) {
      this.visitor = null;
    } else {
      VisitorEntity visitorEntity = new VisitorEntity();
      visitorEntity.setId(visitorId);
      this.visitor = visitorEntity;
    }
  }

}
