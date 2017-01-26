package com.stockboo.app.domain;

/**
 * DTO for Installation JSON
 * 
 * @author sunil.r
 *
 */
public class InstallCreate {

	String appIdentifier;
	String appName;
	String appVersion;
	String deviceType;
	String deviceToken;
	String timeZone;

	/**
	 * 
	 */
	public InstallCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param appIdentifier
	 * @param appName
	 * @param appVersion
	 * @param deviceType
	 * @param timeZone
	 */
	public InstallCreate(String appIdentifier, String appName, String appVersion, String deviceType,
			String deviceToken, String timeZone) {
		super();
		this.appIdentifier = appIdentifier;
		this.appName = appName;
		this.appVersion = appVersion;
		this.deviceType = deviceType;
		this.timeZone = timeZone;
		this.deviceToken = deviceToken;
	}

	/**
	 * @return the appIdentifier
	 */
	public String getAppIdentifier() {
		return appIdentifier;
	}

	/**
	 * @param appIdentifier
	 *            the appIdentifier to set
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
	 * @param appName
	 *            the appName to set
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
	 * @param appVersion
	 *            the appVersion to set
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
	 * @param deviceType
	 *            the deviceType to set
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
	 * @param deviceToken
	 *            the deviceToken to set
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	/**
	 * @return the timeZone
	 */
	public String getTimeZone() {
		return this.timeZone;
	}

	/**
	 * @param timeZone
	 *            the timeZone to set
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

}
