/**
 * 
 */
package com.stockboo.app.domain;

import com.google.appengine.api.datastore.Email;

/**
 * @author jayavardhan
 *
 */
public class AdvisorCreate {

	private String name;

	private String info;

	private Email email;

//	@Size(max=16)
	private String mobileNumber;

	private String password;

	public AdvisorCreate() {

	}

	/**
	 * 
	 * @param name
	 * @param info
	 * @param isSuperAdmin
	 * @param isAdvisorBlocked
	 * @param email
	 * @param mobileNumber
	 * @param password
	 * @param createdAt
	 */
	public AdvisorCreate(String name, String info, Email email,
			String mobileNumber, String password) {
		super();
		this.name = name;
		this.info = info;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
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
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(Email email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	

}
