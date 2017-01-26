package com.stockboo.app.domain;

/**
 * DTO for Installation JSON
 * 
 * @author sunil.r
 *
 */
public class InstallUpdate {

	Long installationId;
	String appVersion;
	String deviceToken;

	public InstallUpdate() {
		super();
	}

	/**
	 * @param appVersion
	 * @param deviceToken
	 */
	public InstallUpdate(Long installationId, String appVersion, String deviceToken) {
		super();
		this.appVersion = appVersion;
		this.deviceToken = deviceToken;
		this.installationId = installationId;
	}

	/**
	 * @return the installationId
	 */
	public Long getInstallationId() {
		return installationId;
	}

	/**
	 * @param installationId
	 *            the installationId to set
	 */
	public void setInstallationId(Long installationId) {
		this.installationId = installationId;
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

}
