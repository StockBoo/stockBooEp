/**
 * 
 */
package com.stockboo.app.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Email;

/**
 * @author jayavardhan
 *
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AdvisorEntity {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long advisorId;

	@Persistent
	private String name;

	@Persistent
	private String info;

	@Persistent
	private boolean isSuperAdmin;

	@Persistent
	private boolean isAdvisorBlocked;

	@Persistent
	private Email email;

	@Persistent
	private String mobileNumber;

	@Persistent
	private String password;

	@Persistent
	private Date createdAt;

	@Persistent
	private Date updatedAt;
	
	@Persistent
	private Date lastLogin;

	public AdvisorEntity() {

		// TODO Auto-generated constructor stub
	}

	public AdvisorEntity(String name, String info, boolean superAdminFlag, boolean advisorBlockedFlag, Email email, String mobileNumber, String password,
			Date advisorCreatedAt, Date lastLogin) {
		this.name = name;
		this.info = info;
		this.isSuperAdmin = superAdminFlag;
		this.isAdvisorBlocked = advisorBlockedFlag;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.createdAt = advisorCreatedAt;
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the advisorId
	 */
	public Long getAdvisorId() {
		return advisorId;
	}

	/**
	 * @param advisorId
	 *            the advisorId to set
	 */
	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isSuperAdmin
	 */
	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	/**
	 * @param isSuperAdmin
	 *            the isSuperAdmin to set
	 */
	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	/**
	 * @return the isAdvisorBlocked
	 */
	public boolean isAdvisorBlocked() {
		return isAdvisorBlocked;
	}

	/**
	 * @param isAdvisorBlocked
	 *            the isAdvisorBlocked to set
	 */
	public void setAdvisorBlocked(boolean isAdvisorBlocked) {
		this.isAdvisorBlocked = isAdvisorBlocked;
	}

	/**
	 * @return the info
	 */
	public String getInfo() {
		return info;
	}

	/**
	 * @param info
	 *            the info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {	
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
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
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the email
	 */
	public Email getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
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
	 * @param mobileNumber
	 *            the mobileNumber to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
