package com.cap.jumpthequeue.visitormanagement.logic.api.to;

import java.sql.Timestamp;

import io.oasp.module.basic.common.api.to.AbstractEto;

public class QueueEto extends AbstractEto {

  private String name;

  private String surname;

  private Timestamp dateAndTime;

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
   * @return surname
   */
  public String getSurname() {

    return this.surname;
  }

  /**
   * @param surname new value of {@link #getsurname}.
   */
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * @return dateAndTime
   */
  public Timestamp getDateAndTime() {

    return this.dateAndTime;
  }

  /**
   * @param dateAndTime new value of {@link #getdateAndTime}.
   */
  public void setDateAndTime(Timestamp dateAndTime) {

    this.dateAndTime = dateAndTime;
  }

}
