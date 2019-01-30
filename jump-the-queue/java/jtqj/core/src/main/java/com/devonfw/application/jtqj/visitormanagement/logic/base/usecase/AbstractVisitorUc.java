package com.devonfw.application.jtqj.visitormanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.application.jtqj.general.logic.base.AbstractUc;
import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.repo.VisitorRepository;

/**
 * Abstract use case for Visitors, which provides access to the commonly
 * necessary data access objects.
 */
public class AbstractVisitorUc extends AbstractUc {

	/** @see #getVisitorRepository() */
	@Inject
	private VisitorRepository visitorRepository;

	/**
	 * Returns the field 'visitorRepository'.
	 * 
	 * @return the {@link VisitorRepository} instance.
	 */
	public VisitorRepository getVisitorRepository() {

		return this.visitorRepository;
	}

}
