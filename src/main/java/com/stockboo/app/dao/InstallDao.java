package com.stockboo.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.stockboo.app.domain.Install;
import com.stockboo.app.domain.InstallCreate;
import com.stockboo.app.domain.InstallUpdate;
import com.stockboo.app.entity.InstallEntity;

/**
 * DTO for Installation JSON
 * 
 * @author sunil.r
 *
 */
public class InstallDao {

	/**
	 * Reads the installations based in installed id
	 * 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public Install read(Long id) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			InstallEntity entity= pm.getObjectById(InstallEntity.class, id);
			return prepareDomain(entity);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Installation details not found");
		}
		catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}
		
	}

	/**
	 * Create the Installation details in database
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	public Install create(InstallCreate i) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		InstallEntity entity = prepareCreateEntity(i);

		try {
			entity.setCreatedAt(new Date());
			pm.makePersistent(entity);
			AppAuthenticationDao auth = new AppAuthenticationDao();
			Install install = prepareDomain(entity);
			install.setToken(auth.create(entity.getId()));
			return install;
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Lists all the installations
	 * 
	 * @return
	 */
	public List<Install> list() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<InstallEntity> results = null;
		Query query = pm.newQuery(InstallEntity.class);
		results = (List<InstallEntity>) query.execute();
		List<Install> i = new ArrayList<Install>();
		for (InstallEntity installEntity : results) {
			i.add(prepareDomain(installEntity));
		}
		return i;
	}

	/**
	 * Update the version of installation
	 * 
	 * @param i
	 * @return
	 * @throws Exception 
	 */
	public Long update(InstallUpdate i) throws Exception {
		if(null==i.getInstallationId())
			throw new Exception("Installation Id is required");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		InstallEntity entity = null;
		try {
			entity = pm.getObjectById(InstallEntity.class, i.getInstallationId());
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Installtion details not found");
		}

		entity.setAppVersion(i.getAppVersion());
		entity.setAppVersion(i.getDeviceToken());
		entity.setUpdatedAt(new Date());
		try {
			pm.makePersistent(entity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("System error");
		}

		return entity.getId();
	}

	/*
	 * Converts db entity to rest object
	 */
	private Install prepareDomain(InstallEntity i) {
		return new Install(i.getId(), i.getAppIdentifier(), i.getAppName(), i.getAppVersion(), i.getDeviceType(), i.getDeviceToken(),
				i.getTimeZone().getID(), i.getCreatedAt(), i.getUpdatedAt());
	}
	
	/*
	 * Prepares entity for create
	 */
	private InstallEntity prepareCreateEntity(InstallCreate i) throws Exception {
		return new InstallEntity(i.getAppIdentifier(), i.getAppName(), i.getAppVersion(), i.getDeviceType(), i.getDeviceToken(),
				getTimezone(i.getTimeZone()), new Date());
	}
	
	private TimeZone getTimezone(String timezone) throws Exception{
		if(null == timezone){throw new Exception("Invalid Timezone");}
		TimeZone t = TimeZone.getTimeZone(timezone);
		return t;
	}

}
