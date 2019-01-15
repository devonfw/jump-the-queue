package com.devonfw.application.jtqj.visitormanagement.logic.impl.usecase;

import java.util.Optional;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;
import com.devonfw.application.jtqj.visitormanagement.logic.api.usecase.UcFindVisitor;
import com.devonfw.application.jtqj.visitormanagement.logic.base.usecase.AbstractVisitorUc;

/**
 * Use case implementation for searching, filtering and getting Visitors
 */
@Named
@Validated
@Transactional
public class UcFindVisitorImpl extends AbstractVisitorUc implements UcFindVisitor {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindVisitorImpl.class);

	@Override
	public VisitorEto findVisitor(long id) {
		LOG.debug("Get Visitor with id {} from database.", id);
		Optional<VisitorEntity> foundEntity = getVisitorRepository().findById(id);
		if (foundEntity.isPresent())
			return getBeanMapper().map(foundEntity.get(), VisitorEto.class);
		else
			return null;
	}

	@Override
	public Page<VisitorEto> findVisitors(VisitorSearchCriteriaTo criteria) {
		Page<VisitorEntity> visitors = getVisitorRepository().findByCriteria(criteria);
		return mapPaginatedEntityList(visitors, VisitorEto.class);
	}

}
