package com.cap.jumpthequeue.usermanagement.logic.api.to;

import java.sql.Timestamp;

import com.cap.jumpthequeue.general.common.api.to.AbstractEto;
import com.cap.jumpthequeue.usermanagement.common.api.User;

/**
 * Entity transport object of User
 */
public class UserEto extends AbstractEto implements User {

  private static final long serialVersionUID = 1L;

  private String name;

  private String email;

  private String phone;

  private String url;

  private String token;

  private String identificator;

  private Boolean consent;

  private Boolean validated;

  private Timestamp creationTime;

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
  public String getUrl() {

    return this.url;
  }

  @Override
  public void setUrl(String url) {

    this.url = url;
  }

  @Override
  public String getToken() {

    return this.token;
  }

  @Override
  public void setToken(String token) {

    this.token = token;
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
  public Boolean getConsent() {

    return this.consent;
  }

  @Override
  public void setConsent(Boolean consent) {

    this.consent = consent;
  }

  @Override
  public Boolean getValidated() {

    return this.validated;
  }

  @Override
  public void setValidated(Boolean validated) {

    this.validated = validated;
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
    result = prime * result + ((this.url == null) ? 0 : this.url.hashCode());
    result = prime * result + ((this.token == null) ? 0 : this.token.hashCode());
    result = prime * result + ((this.identificator == null) ? 0 : this.identificator.hashCode());
    result = prime * result + ((this.consent == null) ? 0 : this.consent.hashCode());
    result = prime * result + ((this.validated == null) ? 0 : this.validated.hashCode());
    result = prime * result + ((this.creationTime == null) ? 0 : this.creationTime.hashCode());

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
    UserEto other = (UserEto) obj;
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
    if (this.url == null) {
      if (other.url != null) {
        return false;
      }
    } else if (!this.url.equals(other.url)) {
      return false;
    }
    if (this.token == null) {
      if (other.token != null) {
        return false;
      }
    } else if (!this.token.equals(other.token)) {
      return false;
    }
    if (this.identificator == null) {
      if (other.identificator != null) {
        return false;
      }
    } else if (!this.identificator.equals(other.identificator)) {
      return false;
    }
    if (this.consent == null) {
      if (other.consent != null) {
        return false;
      }
    } else if (!this.consent.equals(other.consent)) {
      return false;
    }
    if (this.validated == null) {
      if (other.validated != null) {
        return false;
      }
    } else if (!this.validated.equals(other.validated)) {
      return false;
    }
    if (this.creationTime == null) {
      if (other.creationTime != null) {
        return false;
      }
    } else if (!this.creationTime.equals(other.creationTime)) {
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
