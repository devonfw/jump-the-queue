package com.devonfw.application.jtqj.visitormanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.usecase.UcManageVisitor;
import com.devonfw.application.jtqj.visitormanagement.logic.base.usecase.AbstractVisitorUc;

/**
 * Use case implementation for modifying and deleting Visitors
 */
@Named
@Validated
@Transactional
public class UcManageVisitorImpl extends AbstractVisitorUc implements UcManageVisitor {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageVisitorImpl.class);

	@Override
	public boolean deleteVisitor(long visitorId) {

		VisitorEntity visitor = getVisitorRepository().find(visitorId);
		getVisitorRepository().delete(visitor);
		LOG.debug("The visitor with id '{}' has been deleted.", visitorId);
		return true;
	}

	@Override
	public VisitorEto saveVisitor(VisitorEto visitor) {

		Objects.requireNonNull(visitor, "visitor");

		VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);

		// initialize, validate visitorEntity here if necessary
		VisitorEntity resultEntity = getVisitorRepository().save(visitorEntity);
		LOG.debug("Visitor with id '{}' has been created.", resultEntity.getId());
		return getBeanMapper().map(resultEntity, VisitorEto.class);
	}
}
