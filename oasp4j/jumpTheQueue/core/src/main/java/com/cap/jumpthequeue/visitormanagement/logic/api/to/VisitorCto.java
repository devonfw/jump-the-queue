package com.cap.jumpthequeue.visitormanagement.logic.api.to;

import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Visitor
 */
public class VisitorCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private VisitorEto visitor;

  private AccessCodeEto code;

  public VisitorEto getVisitor() {

    return this.visitor;
  }

  public void setVisitor(VisitorEto visitor) {

    this.visitor = visitor;
  }

  public AccessCodeEto getCode() {

    return this.code;
  }

  public void setCode(AccessCodeEto code) {

    this.code = code;
  }

}
