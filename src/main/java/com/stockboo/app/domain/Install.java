package com.stockboo.app.domain;

import java.util.Date;

/**
 * DTO for Installation JSON
 * 
 * @author sunil.r
 *
 */
public class Install {

	Long installationId;
	String appIdentifier;
	String appName;
	String appVersion;
	String deviceType;
	String deviceToken;
	String timeZone;
	String token;
	Date createdAt;
	Date updatedAt;

	/**
	 * 
	 */
	public Install() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param installationId
	 * @param appIdentifier
	 * @param appName
	 * @param appVersion
	 * @param deviceType
	 * @param timeZone
	 * @param createdAt
	 * @param updatedAt
	 * @param deviceToken
	 */
	public Install(Long installationId, String appIdentifier, String appName, String appVersion, String deviceType, String deviceToken,
			String timeZone, Date createdAt, Date updatedAt) {
		super();
		this.installationId = installationId;
		this.appIdentifier = appIdentifier;
		this.appName = appName;
		this.appVersion = appVersion;
		this.deviceType = deviceType;
		this.timeZone = timeZone;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deviceToken = deviceToken;
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
	 * @return the appIdentifier
	 */
	public String getAppIdentifier() {
		return appIdentifier;
	}

	/**
	 * @param appIdentifier the appIdentifier to set
	 */
	public void setAppIdentifier(String appIdentifier) {
		this.appIdentifier = appIdentifier;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the appVersion
	 */
	public String getAppVersion() {
		return appVersion;
	}

	/**
	 * @param appVersion the appVersion to set
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	/**
	 * @return the deviceType
	 */
	public String getDeviceType() {
		return deviceType;
	}

	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	/**
	 * @return the deviceToken
	 */
	public String getDeviceToken() {
		return deviceToken;
	}

	/**
	 * @param deviceToken the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
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

	
	
}
