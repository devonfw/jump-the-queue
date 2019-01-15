package com.devonfw.application.jtqj.queuemanagement.dataaccess.api;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.devonfw.application.jtqj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.jtqj.queuemanagement.common.api.Queue;

@Entity
@Table(name = "DailyQueue")
public class QueueEntity extends ApplicationPersistenceEntity implements Queue {

	private String name;

	private String logo;

	private String currentNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp attentionTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp minAttentionTime;

	private Boolean active;

	private int customers;

	private static final long serialVersionUID = 1L;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the currentNumber
	 */
	public String getCurrentNumber() {
		return currentNumber;
	}

	/**
	 * @param currentNumber the currentNumber to set
	 */
	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}

	/**
	 * @return the attentionTime
	 */
	public Timestamp getAttentionTime() {
		return attentionTime;
	}

	/**
	 * @param attentionTime the attentionTime to set
	 */
	public void setAttentionTime(Timestamp attentionTime) {
		this.attentionTime = attentionTime;
	}

	/**
	 * @return the minAttentionTime
	 */
	public Timestamp getMinAttentionTime() {
		return minAttentionTime;
	}

	/**
	 * @param minAttentionTime the minAttentionTime to set
	 */
	public void setMinAttentionTime(Timestamp minAttentionTime) {
		this.minAttentionTime = minAttentionTime;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the customers
	 */
	public int getCustomers() {
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(int customers) {
		this.customers = customers;
	}

}
