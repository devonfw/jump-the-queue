package com.devonfw.application.jtqj.visitormanagement.logic.api.to;

import com.devonfw.application.jtqj.general.common.api.to.AbstractSearchCriteriaTo;
import com.devonfw.module.basic.common.api.query.StringSearchConfigTo;

/**
 * {@link SearchCriteriaTo} to find instances of
 * {@link com.devonfw.application.jtqj.visitormanagement.common.api.Visitor}s.
 */
public class VisitorSearchCriteriaTo extends AbstractSearchCriteriaTo {

	private static final long serialVersionUID = 1L;

	private String username;
	private String name;
	private String phoneNumber;
	private String password;
	private Boolean acceptedCommercial;
	private Boolean acceptedTerms;
	private Boolean userType;
	private StringSearchConfigTo usernameOption;
	private StringSearchConfigTo nameOption;
	private StringSearchConfigTo phoneNumberOption;
	private StringSearchConfigTo passwordOption;

	/**
	 * @return usernameId
	 */

	public String getUsername() {
		return username;
	}

	/**
	 * @param username setter for username attribute
	 */

	public void setUsername(String username) {
		this.username = username;
	}

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
	 * @return phoneNumberId
	 */

	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber setter for phoneNumber attribute
	 */

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return passwordId
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * @param password setter for password attribute
	 */

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return acceptedCommercialId
	 */

	public Boolean getAcceptedCommercial() {
		return acceptedCommercial;
	}

	/**
	 * @param acceptedCommercial setter for acceptedCommercial attribute
	 */

	public void setAcceptedCommercial(Boolean acceptedCommercial) {
		this.acceptedCommercial = acceptedCommercial;
	}

	/**
	 * @return acceptedTermsId
	 */

	public Boolean getAcceptedTerms() {
		return acceptedTerms;
	}

	/**
	 * @param acceptedTerms setter for acceptedTerms attribute
	 */

	public void setAcceptedTerms(Boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}

	/**
	 * @return userTypeId
	 */

	public Boolean getUserType() {
		return userType;
	}

	/**
	 * @param userType setter for userType attribute
	 */

	public void setUserType(Boolean userType) {
		this.userType = userType;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getUsername() username}.
	 */
	public StringSearchConfigTo getUsernameOption() {

		return this.usernameOption;
	}

	/**
	 * @param usernameOption new value of {@link #getUsernameOption()}.
	 */
	public void setUsernameOption(StringSearchConfigTo usernameOption) {

		this.usernameOption = usernameOption;
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
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getPhoneNumber() phoneNumber}.
	 */
	public StringSearchConfigTo getPhoneNumberOption() {

		return this.phoneNumberOption;
	}

	/**
	 * @param phoneNumberOption new value of {@link #getPhoneNumberOption()}.
	 */
	public void setPhoneNumberOption(StringSearchConfigTo phoneNumberOption) {

		this.phoneNumberOption = phoneNumberOption;
	}

	/**
	 * @return the {@link StringSearchConfigTo} used to search for
	 *         {@link #getPassword() password}.
	 */
	public StringSearchConfigTo getPasswordOption() {

		return this.passwordOption;
	}

	/**
	 * @param passwordOption new value of {@link #getPasswordOption()}.
	 */
	public void setPasswordOption(StringSearchConfigTo passwordOption) {

		this.passwordOption = passwordOption;
	}

}
