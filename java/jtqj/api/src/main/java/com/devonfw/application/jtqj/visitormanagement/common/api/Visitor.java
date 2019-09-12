package com.devonfw.application.jtqj.visitormanagement.common.api;

import com.devonfw.application.jtqj.general.common.api.ApplicationEntity;

public interface Visitor extends ApplicationEntity {

	/**
	 * @return usernameId
	 */

	public String getUsername();

	/**
	 * @param username setter for username attribute
	 */

	public void setUsername(String username);

	/**
	 * @return nameId
	 */

	public String getName();

	/**
	 * @param name setter for name attribute
	 */

	public void setName(String name);

	/**
	 * @return phoneNumberId
	 */

	public String getPhoneNumber();

	/**
	 * @param phoneNumber setter for phoneNumber attribute
	 */

	public void setPhoneNumber(String phoneNumber);

	/**
	 * @return passwordId
	 */

	public String getPassword();

	/**
	 * @param password setter for password attribute
	 */

	public void setPassword(String password);

	/**
	 * @return acceptedCommercialId
	 */

	public Boolean getAcceptedCommercial();

	/**
	 * @param acceptedCommercial setter for acceptedCommercial attribute
	 */

	public void setAcceptedCommercial(Boolean acceptedCommercial);

	/**
	 * @return acceptedTermsId
	 */

	public Boolean getAcceptedTerms();

	/**
	 * @param acceptedTerms setter for acceptedTerms attribute
	 */

	public void setAcceptedTerms(Boolean acceptedTerms);

	/**
	 * @return userTypeId
	 */

	public Boolean getUserType();

	/**
	 * @param userType setter for userType attribute
	 */

	public void setUserType(Boolean userType);

}
