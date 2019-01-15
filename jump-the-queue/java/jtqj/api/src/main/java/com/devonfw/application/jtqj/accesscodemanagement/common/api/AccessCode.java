package com.devonfw.application.jtqj.accesscodemanagement.common.api;

import java.sql.Timestamp;

import com.devonfw.application.jtqj.general.common.api.ApplicationEntity;

public interface AccessCode extends ApplicationEntity {

	/**
	 * @return ticketNumberId
	 */

	public String getTicketNumber();

	/**
	 * @param ticketNumber setter for ticketNumber attribute
	 */

	public void setTicketNumber(String ticketNumber);

	/**
	 * @return creationTimeId
	 */

	public Timestamp getCreationTime();

	/**
	 * @param creationTime setter for creationTime attribute
	 */

	public void setCreationTime(Timestamp creationTime);

	/**
	 * @return startTimeId
	 */

	public Timestamp getStartTime();

	/**
	 * @param startTime setter for startTime attribute
	 */

	public void setStartTime(Timestamp startTime);

	/**
	 * @return endTimeId
	 */

	public Timestamp getEndTime();

	/**
	 * @param endTime setter for endTime attribute
	 */

	public void setEndTime(Timestamp endTime);

	/**
	 * getter for visitorId attribute
	 *
	 * @return visitorId
	 */

	public Long getVisitorId();

	/**
	 * @param visitor setter for visitor attribute
	 */

	public void setVisitorId(Long visitorId);

	/**
	 * getter for queueId attribute
	 *
	 * @return queueId
	 */

	public Long getQueueId();

	/**
	 * @param queue setter for queue attribute
	 */

	public void setQueueId(Long queueId);

}
