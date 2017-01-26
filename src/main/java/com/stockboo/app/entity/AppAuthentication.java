package com.stockboo.app.entity;

import java.util.Date;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * DTO for creating UUID 
 * 
 * @author sunil.r
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class AppAuthentication {
	
	@PrimaryKey
	@Persistent
	Long installationId;
	
	@Persistent
	String token;
	
	@Persistent
	Date tokenCreatedAt;
	
	@Persistent
	Date tokenUpdatedAt;
	
	@Persistent
	Date refreshedDate;

	/**
	 * 
	 */
	public AppAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param installationId
	 * @param token
	 * @param tokenCreatedAt
	 * @param tokenUpdatedAt
	 * @param refreshedDate
	 */
	public AppAuthentication(Long installationId, String token, Date tokenCreatedAt, Date tokenUpdatedAt,
			Date refreshedDate) {
		super();
		this.installationId = installationId;
		this.token = token;
		this.tokenCreatedAt = tokenCreatedAt;
		this.tokenUpdatedAt = tokenUpdatedAt;
		this.refreshedDate = refreshedDate;
	}


	/**
	 * @return the installationId
	 */
	public Long getInstallationId() {
		return installationId;
	}

	/**
	 * @param installationId the installationId to set
	 */
	public void setInstallationId(Long installationId) {
		this.installationId = installationId;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tokenCreatedAt
	 */
	public Date getTokenCreatedAt() {
		return tokenCreatedAt;
	}

	/**
	 * @param tokenCreatedAt the tokenCreatedAt to set
	 */
	public void setTokenCreatedAt(Date tokenCreatedAt) {
		this.tokenCreatedAt = tokenCreatedAt;
	}

	/**
	 * @return the tokenUpdatedAt
	 */
	public Date getTokenUpdatedAt() {
		return tokenUpdatedAt;
	}

	/**
	 * @param tokenUpdatedAt the tokenUpdatedAt to set
	 */
	public void setTokenUpdatedAt(Date tokenUpdatedAt) {
		this.tokenUpdatedAt = tokenUpdatedAt;
	}

	/**
	 * @return the refreshedDate
	 */
	public Date getRefreshedDate() {
		return refreshedDate;
	}

	/**s
	 * @param refreshedDate the refreshedDate to set
	 */
	public void setRefreshedDate(Date refreshedDate) {
		this.refreshedDate = refreshedDate;
	}	
	
	
}
