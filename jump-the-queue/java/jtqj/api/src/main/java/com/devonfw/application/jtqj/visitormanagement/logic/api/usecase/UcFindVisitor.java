package com.devonfw.application.jtqj.visitormanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorEto;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

public interface UcFindVisitor {

	/**
	 * Returns a Visitor by its id 'id'.
	 *
	 * @param id The id 'id' of the Visitor.
	 * @return The {@link VisitorEto} with id 'id'
	 */
	VisitorEto findVisitor(long id);

	/**
	 * Returns a paginated list of Visitors matching the search criteria.
	 *
	 * @param criteria the {@link VisitorSearchCriteriaTo}.
	 * @return the {@link List} of matching {@link VisitorEto}s.
	 */
	Page<VisitorEto> findVisitors(VisitorSearchCriteriaTo criteria);

}
