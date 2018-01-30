package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import com.cap.jumpthequeue.accesscodemanagement.common.api.AccessCode;
import com.cap.jumpthequeue.general.common.api.to.AbstractEto;

/**
 * Entity transport object of AccessCode
 */
public class AccessCodeEto extends AbstractEto implements AccessCode {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private String identificator;

  private Integer code;

  private Boolean priority;

  private Timestamp creationTime;

  private Timestamp startTime;

  private Timestamp endTime;

  private Timestamp estimatedTime;

  private Long queueId;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getEmail() {

    return this.email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  @Override
  public String getPhone() {

    return this.phone;
  }

  @Override
  public void setPhone(String phone) {

    this.phone = phone;
  }

  @Override
  public String getIdentificator() {

    return this.identificator;
  }

  @Override
  public void setIdentificator(String identificator) {

    this.identificator = identificator;
  }

  @Override
  public Integer getCode() {

    return this.code;
  }

  @Override
  public void setCode(Integer code) {

    this.code = code;
  }

  @Override
  public Boolean getPriority() {

    return this.priority;
  }

  @Override
  public void setPriority(Boolean priority) {

    this.priority = priority;
  }

  @Override
  public Timestamp getCreationTime() {

    return this.creationTime;
  }

  @Override
  public void setCreationTime(Timestamp creationTime) {

    this.creationTime = creationTime;
  }

  @Override
  public Timestamp getStartTime() {

    return this.startTime;
  }

  @Override
  public void setStartTime(Timestamp startTime) {

    this.startTime = startTime;
  }

  @Override
  public Timestamp getEndTime() {

    return this.endTime;
  }

  @Override
  public void setEndTime(Timestamp endTime) {

    this.endTime = endTime;
  }

  @Override
  public Timestamp getEstimatedTime() {

    return this.estimatedTime;
  }

  @Override
  public void setEstimatedTime(Timestamp estimatedTime) {

    this.estimatedTime = estimatedTime;
  }

  @Override
  public Long getQueueId() {

    return this.queueId;
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
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.phone == null) ? 0 : this.phone.hashCode());
    result = prime * result + ((this.identificator == null) ? 0 : this.identificator.hashCode());
    result = prime * result + ((this.code == null) ? 0 : this.code.hashCode());
    result = prime * result + ((this.priority == null) ? 0 : this.priority.hashCode());
    result = prime * result + ((this.creationTime == null) ? 0 : this.creationTime.hashCode());
    result = prime * result + ((this.startTime == null) ? 0 : this.startTime.hashCode());
    result = prime * result + ((this.endTime == null) ? 0 : this.endTime.hashCode());
    result = prime * result + ((this.estimatedTime == null) ? 0 : this.estimatedTime.hashCode());

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
    AccessCodeEto other = (AccessCodeEto) obj;
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
    if (this.identificator == null) {
      if (other.identificator != null) {
        return false;
      }
    } else if (!this.identificator.equals(other.identificator)) {
      return false;
    }
    if (this.code == null) {
      if (other.code != null) {
        return false;
      }
    } else if (!this.code.equals(other.code)) {
      return false;
    }
    if (this.priority == null) {
      if (other.priority != null) {
        return false;
      }
    } else if (!this.priority.equals(other.priority)) {
      return false;
    }
    if (this.creationTime == null) {
      if (other.creationTime != null) {
        return false;
      }
    } else if (!this.creationTime.equals(other.creationTime)) {
      return false;
    }
    if (this.startTime == null) {
      if (other.startTime != null) {
        return false;
      }
    } else if (!this.startTime.equals(other.startTime)) {
      return false;
    }
    if (this.endTime == null) {
      if (other.endTime != null) {
        return false;
      }
    } else if (!this.endTime.equals(other.endTime)) {
      return false;
    }
    if (this.estimatedTime == null) {
      if (other.estimatedTime != null) {
        return false;
      }
    } else if (!this.estimatedTime.equals(other.estimatedTime)) {
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
