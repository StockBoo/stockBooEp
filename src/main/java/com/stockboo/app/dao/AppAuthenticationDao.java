/**
 * 
 */
package com.stockboo.app.dao;

import java.util.Date;
import java.util.UUID;

import javax.jdo.PersistenceManager;

import com.google.api.server.spi.response.UnauthorizedException;
//import com.google.appengine.repackaged.org.joda.time.Days;
//import com.google.appengine.repackaged.org.joda.time.LocalDate;
import com.stockboo.app.configuration.Constants;
import com.stockboo.app.entity.AppAuthentication;

/**
 * @author sunil.r
 *
 */

public class AppAuthenticationDao {

	/**
	 * This API creates an entry in the DB when a new installation is done This
	 * will be called in installation create API
	 * 
	 * @param installationId
	 * @return
	 * @throws Exception
	 */
	public String create(Long installationId) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UUID uuid = UUID.randomUUID();
		AppAuthentication auth = new AppAuthentication(installationId, uuid.toString(), new Date(), new Date(),
				new Date());
		try {
			pm.makePersistent(auth);
			return auth.getToken();
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Functionality: This is the refresh APi, If token is not updated in
	 * 90days then ask user to Update UUID If UUID validity is within 90days
	 * then update refresh date.
	 * 
	 * @param installationdId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public boolean refresh(Long installationdId, String token) throws Exception {
		if (null == installationdId)
			throw new Exception("Installation Id is required");
		if (null == token)
			throw new Exception("Token is required");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			AppAuthentication auth = pm.getObjectById(AppAuthentication.class, installationdId);
			if (!(auth.getToken().equalsIgnoreCase(token) && installationdId != auth.getInstallationId())) {
				throw new UnauthorizedException("authorization failed");
			}
			long tokenValidity = getNumberOfDays(auth.getTokenUpdatedAt(), new Date());
			if (tokenValidity > Integer.parseInt(Constants.AUTH_TOKEN_VALIDITY)) {
				throw new UnauthorizedException("authorization failed, update the token");
			}
			auth.setRefreshedDate(new Date());
			pm.makePersistent(auth);
			return true;
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new UnauthorizedException("authorization error");
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Updates UUID in DB, this will be called when UUID validity expires
	 * 
	 * @param installationId
	 * @param token 
	 * @return
	 * @throws Exception
	 */
	public String update(Long installationId, String token) throws Exception {
		if (null == installationId)
			throw new Exception("Installation Id is required");
		if (null == token)
			throw new Exception("Token is required");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UUID uuid = UUID.randomUUID();
		AppAuthentication auth = pm.getObjectById(AppAuthentication.class, installationId);
		if (!(auth.getToken().equalsIgnoreCase(token))) {
			throw new UnauthorizedException("Not a valid token");
		}
		auth.setToken(uuid.toString());
		auth.setTokenUpdatedAt(new Date());
		auth.setRefreshedDate(new Date());
		try {
			pm.makePersistent(auth);
			return auth.getToken();
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	private long getNumberOfDays(Date startDate, Date endDate) {
		// Date date1;
		// Date date2;
		// SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");

		// Setting dates
		// date1 = dates.parse(startDate);
		// date2 = dates.parse(endDate);

		// Comparing dates
		long difference = Math.abs(startDate.getTime() - endDate.getTime());
		long differenceDates = difference / (24 * 60 * 60 * 1000);

		// Convert long to String
		return differenceDates;

	}

	/**
	 * This Will be called in all the APIs, if it is TRUE then allowed to access
	 * else Exception will be thrown
	 * 
	 * @param installationdId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public boolean checkRefreshValidity(Long installationdId, String token) throws Exception {

		if (null == installationdId)
			throw new Exception("Installation Id is required");
		if (null == token)
			throw new Exception("Token is required");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			AppAuthentication auth = pm.getObjectById(AppAuthentication.class, installationdId);
			if (!(auth.getToken().equalsIgnoreCase(token))) {
				throw new UnauthorizedException("authorization failed");
			}
			long refreshValidity = getNumberOfDays(auth.getRefreshedDate(), new Date());
			System.out.println("Refresh validity:" +refreshValidity);
			if (refreshValidity > Long.parseLong(Constants.REFRESH_VALIDITY)) {
				throw new UnauthorizedException("authorization failed, refresh the token");
			}
			// if (auth.getRefreshedDate().)

			// if token is not updated after 45days throrw error to call token
			// update
			// if tockjen validaty isn der
			// then uypdate refrsh date
			// auth.setRefreshedDate(new Date());
			// pm.makePersistent(auth);
			return true;
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new UnauthorizedException("authorization error");
		} catch (Exception e) {
			System.out.println(e);
			throw new UnauthorizedException("authorization error");
		} finally {
			pm.close();
		}

	}

}
