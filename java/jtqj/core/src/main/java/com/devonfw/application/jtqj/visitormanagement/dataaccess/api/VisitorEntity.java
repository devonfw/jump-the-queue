package com.devonfw.application.jtqj.visitormanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.devonfw.application.jtqj.general.common.api.validation.EmailExtended;
import com.devonfw.application.jtqj.general.common.api.validation.Phone;
import com.devonfw.application.jtqj.general.dataaccess.api.ApplicationPersistenceEntity;
import com.devonfw.application.jtqj.visitormanagement.common.api.Visitor;

@Entity
@Table(name = "Visitor")
public class VisitorEntity extends ApplicationPersistenceEntity implements Visitor {


	@NotNull
	@EmailExtended
	private String username;

	@NotNull
	private String name;

	@Phone
	@NotNull
	private String phoneNumber;

	@NotNull
	private String password;

	@NotNull
	private Boolean acceptedCommercial;

	@NotNull
	private Boolean acceptedTerms;

	@NotNull
	private Boolean userType;

	private static final long serialVersionUID = 1L;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the acceptedCommercial
	 */
	public Boolean getAcceptedCommercial() {
		return acceptedCommercial;
	}

	/**
	 * @param acceptedCommercial the acceptedCommercial to set
	 */
	public void setAcceptedCommercial(Boolean acceptedCommercial) {
		this.acceptedCommercial = acceptedCommercial;
	}

	/**
	 * @return the acceptedTerms
	 */
	public Boolean getAcceptedTerms() {
		return acceptedTerms;
	}

	/**
	 * @param acceptedTerms the acceptedTerms to set
	 */
	public void setAcceptedTerms(Boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}

	/**
	 * @return the userType
	 */
	public Boolean getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(Boolean userType) {
		this.userType = userType;
	}

}
