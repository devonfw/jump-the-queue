package com.devonfw.application.jtqj.accesscodemanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.repo.AccessCodeRepository;
import com.devonfw.application.jtqj.general.logic.base.AbstractUc;

/**
 * Abstract use case for AccessCodes, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractAccessCodeUc extends AbstractUc {

	/** @see #getAccessCodeRepository() */
	@Inject
	private AccessCodeRepository accessCodeRepository;

	/**
	 * Returns the field 'accessCodeRepository'.
	 * 
	 * @return the {@link AccessCodeRepository} instance.
	 */
	public AccessCodeRepository getAccessCodeRepository() {

		return this.accessCodeRepository;
	}

}
