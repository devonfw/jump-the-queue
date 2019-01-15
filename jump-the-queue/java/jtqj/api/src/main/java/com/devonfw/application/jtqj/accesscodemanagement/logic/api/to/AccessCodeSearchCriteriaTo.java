package com.devonfw.application.jtqj.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import com.devonfw.application.jtqj.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.jtqj.accesscodemanagement.common.api.AccessCode}s.
 */
public class AccessCodeSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String ticketNumber;
	private Timestamp creationTime;
	private Timestamp startTime;
	private Timestamp endTime;

	private Long visitorId;

	private Long queueId;
	private StringSearchConfigTo ticketNumberOption;

	/**
	 * @return ticketNumberId
	 */

	public String getTicketNumber() {
		return ticketNumber;
	}

	/**
	 * @param ticketNumber setter for ticketNumber attribute
	 */

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	/**
	 * @return creationTimeId
	 */

	public Timestamp getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime setter for creationTime attribute
	 */

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return startTimeId
	 */

	public Timestamp getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime setter for startTime attribute
	 */

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return endTimeId
	 */

	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime setter for endTime attribute
	 */

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	/**
	 * getter for visitorId attribute
	 *
	 * @return visitorId
	 */

	public Long getVisitorId() {
		return visitorId;
	}

	/**
	 * @param visitor setter for visitor attribute
	 */

	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	/**
	 * getter for queueId attribute
	 *
	 * @return queueId
	 */

	public Long getQueueId() {
		return queueId;
	}

	/**
	 * @param queue setter for queue attribute
	 */

	public void setQueueId(Long queueId) {
		this.queueId = queueId;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getTicketNumber() ticketNumber}.
	 */
	public StringSearchConfigTo getTicketNumberOption() {

		return this.ticketNumberOption;
	}

	/**
	 * @param ticketNumberOption new value of {@link #getTicketNumberOption()}.
	 */
	public void setTicketNumberOption(StringSearchConfigTo ticketNumberOption) {

		this.ticketNumberOption = ticketNumberOption;
	}

}
