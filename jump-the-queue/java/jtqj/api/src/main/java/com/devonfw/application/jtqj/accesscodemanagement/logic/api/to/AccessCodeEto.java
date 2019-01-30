package com.devonfw.application.jtqj.accesscodemanagement.logic.api.to;

import java.sql.Timestamp;

import com.devonfw.application.jtqj.accesscodemanagement.common.api.AccessCode;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of AccessCode
 */
public class AccessCodeEto extends AbstractEto implements AccessCode {

	private static final long serialVersionUID = 1L;

	private String ticketNumber;
	private Timestamp creationTime;
	private Timestamp startTime;
	private Timestamp endTime;

	private Long visitorId;

	private Long queueId;

	@Override
	public String getTicketNumber() {
		return ticketNumber;
	}

	@Override
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	@Override
	public Timestamp getCreationTime() {
		return creationTime;
	}

	@Override
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public Timestamp getStartTime() {
		return startTime;
	}

	@Override
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Override
	public Timestamp getEndTime() {
		return endTime;
	}

	@Override
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Override
	public Long getVisitorId() {
		return visitorId;
	}

	@Override
	public void setVisitorId(Long visitorId) {
		this.visitorId = visitorId;
	}

	@Override
	public Long getQueueId() {
		return queueId;
	}

	@Override
	public void setQueueId(Long queueId) {
		this.queueId = queueId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.ticketNumber == null) ? 0 : this.ticketNumber.hashCode());
		result = prime * result + ((this.creationTime == null) ? 0 : this.creationTime.hashCode());
		result = prime * result + ((this.startTime == null) ? 0 : this.startTime.hashCode());
		result = prime * result + ((this.endTime == null) ? 0 : this.endTime.hashCode());

		result = prime * result + ((this.visitorId == null) ? 0 : this.visitorId.hashCode());

		result = prime * result + ((this.queueId == null) ? 0 : this.queueId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		// class check will be done by super type EntityTo!
		if (!super.equals(obj)) {
			return false;
		}
		AccessCodeEto other = (AccessCodeEto) obj;
		if (this.ticketNumber == null) {
			if (other.ticketNumber != null) {
				return false;
			}
		} else if (!this.ticketNumber.equals(other.ticketNumber)) {
			return false;
		}
		if (this.creationTime == null) {
			if (other.creationTime != null) {
				return false;
			}
		} else if (!this.creationTime.equals(other.creationTime)) {
			return false;
		}
		if (this.startTime == null) {
			if (other.startTime != null) {
				return false;
			}
		} else if (!this.startTime.equals(other.startTime)) {
			return false;
		}
		if (this.endTime == null) {
			if (other.endTime != null) {
				return false;
			}
		} else if (!this.endTime.equals(other.endTime)) {
			return false;
		}

		if (this.visitorId == null) {
			if (other.visitorId != null) {
				return false;
			}
		} else if (!this.visitorId.equals(other.visitorId)) {
			return false;
		}

		if (this.queueId == null) {
			if (other.queueId != null) {
				return false;
			}
		} else if (!this.queueId.equals(other.queueId)) {
			return false;
		}
		return true;
	}
}
