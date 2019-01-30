package com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link AccessCodeEntity}
 */
public interface AccessCodeRepository extends DefaultRepository<AccessCodeEntity> {

	/**
	 * @param criteria    the {@link AccessCodeSearchCriteriaTo} with the criteria
	 *                    to search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link AccessCodeEntity} objects that matched
	 *         the search.
	 */
	default Page<AccessCodeEntity> findByCriteria(AccessCodeSearchCriteriaTo criteria) {

		AccessCodeEntity alias = newDslAlias();
		JPAQuery<AccessCodeEntity> query = newDslQuery(alias);

		String ticketNumber = criteria.getTicketNumber();
		if (ticketNumber != null && !ticketNumber.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getTicketNumber()), ticketNumber,
					criteria.getTicketNumberOption());
		}
		Timestamp creationTime = criteria.getCreationTime();
		if (creationTime != null) {
			query.where($(alias.getCreationTime()).eq(creationTime));
		}
		Timestamp startTime = criteria.getStartTime();
		if (startTime != null) {
			query.where($(alias.getStartTime()).eq(startTime));
		}
		Timestamp endTime = criteria.getEndTime();
		if (endTime != null) {
			query.where($(alias.getEndTime()).eq(endTime));
		}
		Long visitor = criteria.getVisitorId();
		if (visitor != null) {
			query.where($(alias.getVisitor().getId()).eq(visitor));
		}
		Long queue = criteria.getQueueId();
		if (queue != null) {
			query.where($(alias.getQueue().getId()).eq(queue));
		}
		addOrderBy(query, alias, criteria.getPageable().getSort());

		return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
	}

	/**
	 * Add sorting to the given query on the given alias
	 *
	 * @param query to add sorting to
	 * @param alias to retrieve columns from for sorting
	 * @param sort  specification of sorting
	 */
	public default void addOrderBy(JPAQuery<AccessCodeEntity> query, AccessCodeEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "ticketNumber":
					if (next.isAscending()) {
						query.orderBy($(alias.getTicketNumber()).asc());
					} else {
						query.orderBy($(alias.getTicketNumber()).desc());
					}
					break;
				case "creationTime":
					if (next.isAscending()) {
						query.orderBy($(alias.getCreationTime()).asc());
					} else {
						query.orderBy($(alias.getCreationTime()).desc());
					}
					break;
				case "startTime":
					if (next.isAscending()) {
						query.orderBy($(alias.getStartTime()).asc());
					} else {
						query.orderBy($(alias.getStartTime()).desc());
					}
					break;
				case "endTime":
					if (next.isAscending()) {
						query.orderBy($(alias.getEndTime()).asc());
					} else {
						query.orderBy($(alias.getEndTime()).desc());
					}
					break;
				case "visitor":
					if (next.isAscending()) {
						query.orderBy($(alias.getVisitor().getId()).asc());
					} else {
						query.orderBy($(alias.getVisitor().getId()).desc());
					}
					break;
				case "queue":
					if (next.isAscending()) {
						query.orderBy($(alias.getQueue().getId()).asc());
					} else {
						query.orderBy($(alias.getQueue().getId()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}