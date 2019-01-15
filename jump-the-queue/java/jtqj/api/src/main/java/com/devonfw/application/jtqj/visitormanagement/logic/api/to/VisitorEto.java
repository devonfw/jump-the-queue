package com.devonfw.application.jtqj.visitormanagement.logic.api.to;

import com.devonfw.application.jtqj.visitormanagement.common.api.Visitor;
import com.devonfw.module.basic.common.api.to.AbstractEto;

/**
 * Entity transport object of Visitor
 */
public class VisitorEto extends AbstractEto implements Visitor {

	private static final long serialVersionUID = 1L;

	private String username;
	private String name;
	private String phoneNumber;
	private String password;
	private Boolean acceptedCommercial;
	private Boolean acceptedTerms;
	private Boolean userType;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Boolean getAcceptedCommercial() {
		return acceptedCommercial;
	}

	@Override
	public void setAcceptedCommercial(Boolean acceptedCommercial) {
		this.acceptedCommercial = acceptedCommercial;
	}

	@Override
	public Boolean getAcceptedTerms() {
		return acceptedTerms;
	}

	@Override
	public void setAcceptedTerms(Boolean acceptedTerms) {
		this.acceptedTerms = acceptedTerms;
	}

	@Override
	public Boolean getUserType() {
		return userType;
	}

	@Override
	public void setUserType(Boolean userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
		result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
		result = prime * result + ((this.acceptedCommercial == null) ? 0 : this.acceptedCommercial.hashCode());
		result = prime * result + ((this.acceptedTerms == null) ? 0 : this.acceptedTerms.hashCode());
		result = prime * result + ((this.userType == null) ? 0 : this.userType.hashCode());
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
		VisitorEto other = (VisitorEto) obj;
		if (this.username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!this.username.equals(other.username)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!this.phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		if (this.password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!this.password.equals(other.password)) {
			return false;
		}
		if (this.acceptedCommercial == null) {
			if (other.acceptedCommercial != null) {
				return false;
			}
		} else if (!this.acceptedCommercial.equals(other.acceptedCommercial)) {
			return false;
		}
		if (this.acceptedTerms == null) {
			if (other.acceptedTerms != null) {
				return false;
			}
		} else if (!this.acceptedTerms.equals(other.acceptedTerms)) {
			return false;
		}
		if (this.userType == null) {
			if (other.userType != null) {
				return false;
			}
		} else if (!this.userType.equals(other.userType)) {
			return false;
		}
		return true;
	}
}
