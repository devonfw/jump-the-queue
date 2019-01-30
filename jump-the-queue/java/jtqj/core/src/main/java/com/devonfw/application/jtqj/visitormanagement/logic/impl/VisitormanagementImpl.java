package com.devonfw.application.jtqj.visitormanagement.logic.impl;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.general.logic.base.AbstractComponentFacade;
import com.devonfw.application.jtqj.visitormanagement.logic.api.Visitormanagement;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;
import com.devonfw.application.jtqj.visitormanagement.logic.api.usecase.UcFindVisitor;
import com.devonfw.application.jtqj.visitormanagement.logic.api.usecase.UcManageVisitor;

/**
 * Implementation of component interface of visitormanagement
 */
@Named
public class VisitormanagementImpl extends AbstractComponentFacade implements Visitormanagement {

	@Inject
	private UcFindVisitor ucFindVisitor;

	@Inject
	private UcManageVisitor ucManageVisitor;

	@Override
	public VisitorEto findVisitor(long id) {

		return this.ucFindVisitor.findVisitor(id);
	}

	@Override
	public Page<VisitorEto> findVisitors(VisitorSearchCriteriaTo criteria) {
		return this.ucFindVisitor.findVisitors(criteria);
	}

	@Override
	public VisitorEto saveVisitor(VisitorEto visitor) {

		return this.ucManageVisitor.saveVisitor(visitor);
	}

	@Override
	public boolean deleteVisitor(long id) {

		return this.ucManageVisitor.deleteVisitor(id);
	}
}
