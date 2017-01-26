package com.stockboo.app.entity;

import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * DTO for Installation
 * This class will create, update, read, list operations of installation
 * 
 * @author sunil.r
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class InstallEntity {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	String appIdentifier;
	
	@Persistent
	String appName;
	
	@Persistent
	String appVersion;
	
	@Persistent
	String deviceType;
	
	@Persistent
	String deviceToken;

	@Persistent
	TimeZone timeZone;
	
	@Persistent
	String installationId;
	
	@Persistent
	Date createdAt;
	
	@Persistent
	Date updatedAt;
	

	/**
	 * 
	 */
	public InstallEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param appIdentifier
	 * @param appName
	 * @param appVersion
	 * @param deviceType
	 * @param timeZone
	 * @param installationId
	 * @param createdAt
	 * @param updatedAt
	 */
	public InstallEntity(String appIdentifier, String appName, String appVersion, String deviceType, String deviceToken, TimeZone timeZone,
			Date createdAt) {
		super();
		this.appIdentifier = appIdentifier;
		this.appName = appName;
		this.appVersion = appVersion;
		this.deviceType = deviceType;
		this.timeZone = timeZone;
		this.createdAt = createdAt;
		this. deviceToken = deviceToken;
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
	 * @return the timeZone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * @return the installationId
	 */
	public String getInstallationId() {
		return installationId;
	}

	/**
	 * @param installationId the installationId to set
	 */
	public void setInstallationId(String installationId) {
		this.installationId = installationId;
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
		
}
