package com.devonfw.application.jtqj.accesscodemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.accesscodemanagement.logic.api.Accesscodemanagement;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcFindAccessCode;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcManageAccessCode;
import com.devonfw.application.jtqj.general.logic.base.AbstractComponentFacade;

/**
 * Implementation of component interface of accesscodemanagement
 */
@Named
public class AccesscodemanagementImpl extends AbstractComponentFacade implements Accesscodemanagement {

	@Inject
	private UcFindAccessCode ucFindAccessCode;

	@Inject
	private UcManageAccessCode ucManageAccessCode;

	@Override
	public AccessCodeCto findAccessCodeCto(long id) {

		return this.ucFindAccessCode.findAccessCodeCto(id);
	}

	@Override
	public Page<AccessCodeCto> findAccessCodeCtos(AccessCodeSearchCriteriaTo criteria) {
		return this.ucFindAccessCode.findAccessCodeCtos(criteria);
	}

	@Override
	public Boolean deleteAccessCode(long accessCodeId) {
		return this.ucManageAccessCode.deleteAccessCode(accessCodeId);
	}

	@Override
	public AccessCodeEto saveAccessCode(AccessCodeEto accessCodeEto) {
		return this.ucManageAccessCode.saveAccessCode(accessCodeEto);
	}
}