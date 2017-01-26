/**
 * 
 */
package com.stockboo.app.domain;

/**
 * @author sunil.r
 *
 */
public class TokenUpdate {

	private Long installationId; 
	private String token;
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
	
	
}
