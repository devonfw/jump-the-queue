package com.devonfw.application.jtqj.accesscodemanagement.logic.impl.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcFindAccessCode;
import com.devonfw.application.jtqj.accesscodemanagement.logic.base.usecase.AbstractAccessCodeUc;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;

/**
 * Use case implementation for searching, filtering and getting AccessCodes
 */
@Named
@Validated
@Transactional
@Primary
public class UcFindAccessCodeImpl extends AbstractAccessCodeUc implements UcFindAccessCode {

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcFindAccessCodeImpl.class);

	@Override
	public AccessCodeCto findAccessCodeCto(long id) {
		LOG.debug("Get AccessCodeCto with id {} from database.", id);
		AccessCodeEntity entity = getAccessCodeRepository().find(id);
		AccessCodeCto cto = new AccessCodeCto();
		cto.setAccessCode(getBeanMapper().map(entity, AccessCodeEto.class));
		cto.setVisitor(getBeanMapper().map(entity.getVisitor(), VisitorEto.class));
		cto.setQueue(getBeanMapper().map(entity.getQueue(), QueueEto.class));

		return cto;
	}

	@Override
	public Page<AccessCodeCto> findAccessCodeCtos(AccessCodeSearchCriteriaTo criteria) {

		Page<AccessCodeEntity> accesscodes = getAccessCodeRepository().findByCriteria(criteria);
		List<AccessCodeCto> ctos = new ArrayList<>();
		for (AccessCodeEntity entity : accesscodes.getContent()) {
			AccessCodeCto cto = new AccessCodeCto();
			cto.setAccessCode(getBeanMapper().map(entity, AccessCodeEto.class));
			cto.setVisitor(getBeanMapper().map(entity.getVisitor(), VisitorEto.class));
			cto.setQueue(getBeanMapper().map(entity.getQueue(), QueueEto.class));
			ctos.add(cto);
		}
		Pageable pagResultTo = PageRequest.of(criteria.getPageable().getPageNumber(),
				criteria.getPageable().getPageSize());

		return new PageImpl<>(ctos, pagResultTo, accesscodes.getTotalElements());
	}
}
