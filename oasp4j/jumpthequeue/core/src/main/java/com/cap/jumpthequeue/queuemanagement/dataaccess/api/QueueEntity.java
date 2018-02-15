package com.cap.jumpthequeue.queuemanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.OwnerEntity;
import com.cap.jumpthequeue.general.dataaccess.api.ApplicationPersistenceEntity;
import com.cap.jumpthequeue.queuemanagement.common.api.Queue;

/**
 * @author machamou
 */
@Entity
@Table(name = "Queue")
public class QueueEntity extends ApplicationPersistenceEntity implements Queue {

  private String descriptionText;

  private long minWait;

  private TermsEntity terms;

  private OwnerEntity owner;

  private static final long serialVersionUID = 1L;

  /**
   * @return descriptionText
   */
  public String getDescriptionText() {

    return this.descriptionText;
  }

  /**
   * @param descriptionText new value of {@link #getdescriptionText}.
   */
  public void setDescriptionText(String descriptionText) {

    this.descriptionText = descriptionText;
  }

  /**
   * @return minWait
   */
  public long getMinWait() {

    return this.minWait;
  }

  /**
   * @param minWait new value of {@link #getminWait}.
   */
  public void setMinWait(long minWait) {

    this.minWait = minWait;
  }

  /**
   * @return terms
   */
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idTerms")
  public TermsEntity getTerms() {

    return this.terms;
  }

  /**
   * @param terms new value of {@link #getterms}.
   */
  public void setTerms(TermsEntity terms) {

    this.terms = terms;
  }

  /**
   * @return owner
   */
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "idOwner")
  public OwnerEntity getOwner() {

    return this.owner;
  }

  /**
   * @param owner new value of {@link #getowner}.
   */
  public void setOwner(OwnerEntity owner) {

    this.owner = owner;
  }

  @Override
  @Transient
  public Long getTermsId() {

    if (this.terms == null) {
      return null;
    }
    return this.terms.getId();
  }

  @Override
  public void setTermsId(Long termsId) {

    if (termsId == null) {
      this.terms = null;
    } else {
      TermsEntity termsEntity = new TermsEntity();
      termsEntity.setId(termsId);
      this.terms = termsEntity;
    }
  }

  @Override
  @Transient
  public Long getOwnerId() {

    if (this.owner == null) {
      return null;
    }
    return this.owner.getId();
  }

  @Override
  public void setOwnerId(Long ownerId) {

    if (ownerId == null) {
      this.owner = null;
    } else {
      OwnerEntity ownerEntity = new OwnerEntity();
      ownerEntity.setId(ownerId);
      this.owner = ownerEntity;
    }
  }

}
