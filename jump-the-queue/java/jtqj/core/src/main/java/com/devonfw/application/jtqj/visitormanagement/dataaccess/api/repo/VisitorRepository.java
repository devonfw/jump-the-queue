package com.devonfw.application.jtqj.visitormanagement.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;
import com.devonfw.application.jtqj.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link VisitorEntity}
 */
public interface VisitorRepository extends DefaultRepository<VisitorEntity> {

	/**
	 * @param criteria    the {@link VisitorSearchCriteriaTo} with the criteria to
	 *                    search.
	 * @param pageRequest {@link Pageable} implementation used to set page
	 *                    properties like page size
	 * @return the {@link Page} of the {@link VisitorEntity} objects that matched
	 *         the search.
	 */
	default Page<VisitorEntity> findByCriteria(VisitorSearchCriteriaTo criteria) {

		VisitorEntity alias = newDslAlias();
		JPAQuery<VisitorEntity> query = newDslQuery(alias);

		String username = criteria.getUsername();
		if (username != null && !username.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getUsername()), username, criteria.getUsernameOption());
		}
		String name = criteria.getName();
		if (name != null && !name.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		}
		String phoneNumber = criteria.getPhoneNumber();
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getPhoneNumber()), phoneNumber, criteria.getPhoneNumberOption());
		}
		String password = criteria.getPassword();
		if (password != null && !password.isEmpty()) {
			QueryUtil.get().whereString(query, $(alias.getPassword()), password, criteria.getPasswordOption());
		}
		Boolean acceptedCommercial = criteria.getAcceptedCommercial();
		if (acceptedCommercial != null) {
			query.where($(alias.getAcceptedCommercial()).eq(acceptedCommercial));
		}
		Boolean acceptedTerms = criteria.getAcceptedTerms();
		if (acceptedTerms != null) {
			query.where($(alias.getAcceptedTerms()).eq(acceptedTerms));
		}
		Boolean userType = criteria.getUserType();
		if (userType != null) {
			query.where($(alias.getUserType()).eq(userType));
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
	public default void addOrderBy(JPAQuery<VisitorEntity> query, VisitorEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "username":
					if (next.isAscending()) {
						query.orderBy($(alias.getUsername()).asc());
					} else {
						query.orderBy($(alias.getUsername()).desc());
					}
					break;
				case "name":
					if (next.isAscending()) {
						query.orderBy($(alias.getName()).asc());
					} else {
						query.orderBy($(alias.getName()).desc());
					}
					break;
				case "phoneNumber":
					if (next.isAscending()) {
						query.orderBy($(alias.getPhoneNumber()).asc());
					} else {
						query.orderBy($(alias.getPhoneNumber()).desc());
					}
					break;
				case "password":
					if (next.isAscending()) {
						query.orderBy($(alias.getPassword()).asc());
					} else {
						query.orderBy($(alias.getPassword()).desc());
					}
					break;
				case "acceptedCommercial":
					if (next.isAscending()) {
						query.orderBy($(alias.getAcceptedCommercial()).asc());
					} else {
						query.orderBy($(alias.getAcceptedCommercial()).desc());
					}
					break;
				case "acceptedTerms":
					if (next.isAscending()) {
						query.orderBy($(alias.getAcceptedTerms()).asc());
					} else {
						query.orderBy($(alias.getAcceptedTerms()).desc());
					}
					break;
				case "userType":
					if (next.isAscending()) {
						query.orderBy($(alias.getUserType()).asc());
					} else {
						query.orderBy($(alias.getUserType()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

}