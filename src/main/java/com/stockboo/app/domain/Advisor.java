/**
 * 
 */
package com.stockboo.app.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Email;

/**
 * @author jayavardhan
 *
 */
public class Advisor {

	private Long id;

	private String name;

	private String info;

	private boolean isSuperAdmin;
	
	private boolean isBlocked;

	private Email email;

	@Size(max=16)
	private String mobileNumber;

	private String password;

	private Date createdAt;

	private Date updatedAt;
	
	private Date lastLogin;

	public Advisor() {

	}

	/**
	 * 
	 * @param theadvisorId
	 * @param theName
	 * @param theInfo
	 * @param superAdminFlag
	 * @param advisorBlockedFlag
	 * @param email
	 * @param mobileNumber
	 * @param password
	 * @param advisorCreatedAt
	 * @param advisorUpdatedAt
	 */
	public Advisor(Long id, String name, String info, boolean superAdminFlag,
			boolean advisorBlockedFlag, Email email, String mobileNumber, String password, Date advisorCreatedAt,
			Date advisorUpdatedAt, Date lastLogin) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.isSuperAdmin = superAdminFlag;
		this.isBlocked = advisorBlockedFlag;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.createdAt = advisorCreatedAt;
		this.updatedAt = advisorUpdatedAt;
		this.lastLogin = lastLogin; 
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the isSuperAdmin
	 */
	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	/**
	 * @param isSuperAdmin the isSuperAdmin to set
	 */
	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	/**
	 * @return the isBlocked
	 */
	public boolean isBlocked() {
		return isBlocked;
	}

	/**
	 * @param isBlocked the isBlocked to set
	 */
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
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

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	
}
