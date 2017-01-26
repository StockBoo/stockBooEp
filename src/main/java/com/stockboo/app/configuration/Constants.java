package com.stockboo.app.configuration;

/**
 * Contains the client IDs and scopes for allowed clients consuming your API.
 */
public class Constants {
  public static final String WEB_CLIENT_ID = "703914324096-drubk915sshkgmcarbikisbjg1ju7kds.apps.googleusercontent.com";
  public static final String ANDROID_CLIENT_ID = "replace this with your Android client ID";
  public static final String IOS_CLIENT_ID = "703914324096-clss0rbdjds95fqtuuuci219tmmmd5fm.apps.googleusercontent.com";
  public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;

  public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
  
  //Authorization
  public static final String REFRESH_VALIDITY = "30";
  public static final String AUTH_TOKEN_VALIDITY = "90";
  public static final String AUTH_TOKEN = "X-StockBoo-Token";
  public static final String INSTALLATION_ID = "X-StockBoo-InstallationId";
  
}
