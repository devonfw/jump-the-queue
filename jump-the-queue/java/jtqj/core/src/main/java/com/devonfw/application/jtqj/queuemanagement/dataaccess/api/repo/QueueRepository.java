package com.devonfw.application.jtqj.queuemanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.sql.Timestamp;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link QueueEntity}
 */
public interface QueueRepository extends DefaultRepository<QueueEntity> {

	/**
	 * @param criteria    the {@link QueueSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link QueueEntity} objects that matched the
	 *         search.
	 */
	default Page<QueueEntity> findByCriteria(QueueSearchCriteriaTo criteria) {

		QueueEntity alias = newDslAlias();
		JPAQuery<QueueEntity> query = newDslQuery(alias);

		String name = criteria.getName();
		if (name != null && !name.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		}
		String logo = criteria.getLogo();
		if (logo != null && !logo.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getLogo()), logo, criteria.getLogoOption());
		}
		String currentNumber = criteria.getCurrentNumber();
		if (currentNumber != null && !currentNumber.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getCurrentNumber()), currentNumber,
					criteria.getCurrentNumberOption());
		}
		Timestamp attentionTime = criteria.getAttentionTime();
		if (attentionTime != null) {
			query.where($(alias.getAttentionTime()).eq(attentionTime));
		}
		Timestamp minAttentionTime = criteria.getMinAttentionTime();
		if (minAttentionTime != null) {
			query.where($(alias.getMinAttentionTime()).eq(minAttentionTime));
		}
		Boolean active = criteria.getActive();
		if (active != null) {
			query.where($(alias.getActive()).eq(active));
		}
		Integer customers = criteria.getCustomers();
		if (customers != null) {
			query.where($(alias.getCustomers()).eq(customers));
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
	public default void addOrderBy(JPAQuery<QueueEntity> query, QueueEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "name":
					if (next.isAscending()) {
						query.orderBy($(alias.getName()).asc());
					} else {
						query.orderBy($(alias.getName()).desc());
					}
					break;
				case "logo":
					if (next.isAscending()) {
						query.orderBy($(alias.getLogo()).asc());
					} else {
						query.orderBy($(alias.getLogo()).desc());
					}
					break;
				case "currentNumber":
					if (next.isAscending()) {
						query.orderBy($(alias.getCurrentNumber()).asc());
					} else {
						query.orderBy($(alias.getCurrentNumber()).desc());
					}
					break;
				case "attentionTime":
					if (next.isAscending()) {
						query.orderBy($(alias.getAttentionTime()).asc());
					} else {
						query.orderBy($(alias.getAttentionTime()).desc());
					}
					break;
				case "minAttentionTime":
					if (next.isAscending()) {
						query.orderBy($(alias.getMinAttentionTime()).asc());
					} else {
						query.orderBy($(alias.getMinAttentionTime()).desc());
					}
					break;
				case "active":
					if (next.isAscending()) {
						query.orderBy($(alias.getActive()).asc());
					} else {
						query.orderBy($(alias.getActive()).desc());
					}
					break;
				case "customers":
					if (next.isAscending()) {
						query.orderBy($(alias.getCustomers()).asc());
					} else {
						query.orderBy($(alias.getCustomers()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}