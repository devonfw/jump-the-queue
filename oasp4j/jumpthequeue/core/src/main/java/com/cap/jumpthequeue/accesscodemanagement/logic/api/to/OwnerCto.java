package com.cap.jumpthequeue.accesscodemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Owner
 */
public class OwnerCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private OwnerEto owner;

  public OwnerEto getOwner() {

    return owner;
  }

  public void setOwner(OwnerEto owner) {

    this.owner = owner;
  }

}
