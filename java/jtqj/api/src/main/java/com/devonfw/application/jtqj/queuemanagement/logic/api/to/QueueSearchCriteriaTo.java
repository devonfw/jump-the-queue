package com.devonfw.application.jtqj.queuemanagement.logic.api.to;

import java.sql.Timestamp;

import com.devonfw.application.jtqj.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.jtqj.queuemanagement.common.api.Queue}s.
 */
public class QueueSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String name;
	private String logo;
	private String currentNumber;
	private Timestamp attentionTime;
	private Timestamp minAttentionTime;
	private Boolean active;
	private Integer customers;
	private StringSearchConfigTo nameOption;
	private StringSearchConfigTo logoOption;
	private StringSearchConfigTo currentNumberOption;

	/**
	 * @return nameId
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return logoId
	 */

	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo setter for logo attribute
	 */

	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return currentNumberId
	 */

	public String getCurrentNumber() {
		return currentNumber;
	}

	/**
	 * @param currentNumber setter for currentNumber attribute
	 */

	public void setCurrentNumber(String currentNumber) {
		this.currentNumber = currentNumber;
	}

	/**
	 * @return attentionTimeId
	 */

	public Timestamp getAttentionTime() {
		return attentionTime;
	}

	/**
	 * @param attentionTime setter for attentionTime attribute
	 */

	public void setAttentionTime(Timestamp attentionTime) {
		this.attentionTime = attentionTime;
	}

	/**
	 * @return minAttentionTimeId
	 */

	public Timestamp getMinAttentionTime() {
		return minAttentionTime;
	}

	/**
	 * @param minAttentionTime setter for minAttentionTime attribute
	 */

	public void setMinAttentionTime(Timestamp minAttentionTime) {
		this.minAttentionTime = minAttentionTime;
	}

	/**
	 * @return activeId
	 */

	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active setter for active attribute
	 */

	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return customersId
	 */

	public Integer getCustomers() {
		return customers;
	}

	/**
	 * @param customers setter for customers attribute
	 */

	public void setCustomers(Integer customers) {
		this.customers = customers;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for {@link #getName()
	 *         name}.
	 */
	public StringSearchConfigTo getNameOption() {

		return this.nameOption;
	}

	/**
	 * @param nameOption new value of {@link #getNameOption()}.
	 */
	public void setNameOption(StringSearchConfigTo nameOption) {

		this.nameOption = nameOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for {@link #getLogo()
	 *         logo}.
	 */
	public StringSearchConfigTo getLogoOption() {

		return this.logoOption;
	}

	/**
	 * @param logoOption new value of {@link #getLogoOption()}.
	 */
	public void setLogoOption(StringSearchConfigTo logoOption) {

		this.logoOption = logoOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getCurrentNumber() currentNumber}.
	 */
	public StringSearchConfigTo getCurrentNumberOption() {

		return this.currentNumberOption;
	}

	/**
	 * @param currentNumberOption new value of {@link #getCurrentNumberOption()}.
	 */
	public void setCurrentNumberOption(StringSearchConfigTo currentNumberOption) {

		this.currentNumberOption = currentNumberOption;
	}

}
