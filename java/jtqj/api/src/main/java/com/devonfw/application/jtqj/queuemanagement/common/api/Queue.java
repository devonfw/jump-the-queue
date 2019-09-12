package com.devonfw.application.jtqj.queuemanagement.common.api;

import java.sql.Timestamp;

import com.devonfw.application.jtqj.general.common.api.ApplicationEntity;

public interface Queue extends ApplicationEntity {

	/**
	 * @return nameId
	 */

	public String getName();

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name);

	/**
	 * @return logoId
	 */

	public String getLogo();

	/**
	 * @param logo setter for logo attribute
	 */

	public void setLogo(String logo);

	/**
	 * @return currentNumberId
	 */

	public String getCurrentNumber();

	/**
	 * @param currentNumber setter for currentNumber attribute
	 */

	public void setCurrentNumber(String currentNumber);

	/**
	 * @return attentionTimeId
	 */

	public Timestamp getAttentionTime();

	/**
	 * @param attentionTime setter for attentionTime attribute
	 */

	public void setAttentionTime(Timestamp attentionTime);

	/**
	 * @return minAttentionTimeId
	 */

	public Timestamp getMinAttentionTime();

	/**
	 * @param minAttentionTime setter for minAttentionTime attribute
	 */

	public void setMinAttentionTime(Timestamp minAttentionTime);

	/**
	 * @return activeId
	 */

	public Boolean getActive();

	/**
	 * @param active setter for active attribute
	 */

	public void setActive(Boolean active);

	/**
	 * @return customersId
	 */

	public int getCustomers();

	/**
	 * @param customers setter for customers attribute
	 */

	public void setCustomers(int customers);

}
