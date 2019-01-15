package com.devonfw.application.jtqj.accesscodemanagement.logic.api.to;

import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;
import com.devonfw.module.basic.common.api.to.AbstractCto;

/**
 * Composite transport object of AccessCode
 */
public class AccessCodeCto extends AbstractCto {

	private static final long serialVersionUID = 1L;

	private AccessCodeEto accessCode;

	private VisitorEto visitor;
	private QueueEto queue;

	public AccessCodeEto getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(AccessCodeEto accessCode) {
		this.accessCode = accessCode;
	}

	public VisitorEto getVisitor() {
		return visitor;
	}

	public void setVisitor(VisitorEto visitor) {
		this.visitor = visitor;
	}

	public QueueEto getQueue() {
		return queue;
	}

	public void setQueue(QueueEto queue) {
		this.queue = queue;
	}

}
