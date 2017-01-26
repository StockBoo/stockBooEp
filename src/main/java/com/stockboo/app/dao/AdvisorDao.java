/**
 * 
 */
package com.stockboo.app.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.apache.commons.lang3.StringUtils;

import com.stockboo.app.domain.Advisor;
import com.stockboo.app.domain.AdvisorCreate;
import com.stockboo.app.domain.AdvisorUpdate;
import com.stockboo.app.entity.AdvisorEntity;

import jdk.nashorn.internal.runtime.ECMAException;

/**
 * @author jayavardhan
 *
 */

@SuppressWarnings("all")
public class AdvisorDao {

	/**
	 * Method to create the Advisor
	 * 
	 * @param advisor
	 * @return
	 * @throws Exception
	 */
	public Advisor create(AdvisorCreate advisor) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AdvisorEntity advisorEntity = prepareAdvisorEntity(advisor);
		//Default values
		advisorEntity.setAdvisorBlocked(false);
		advisorEntity.setSuperAdmin(false);
		try {
			advisorEntity.setCreatedAt(new Date());
			advisorEntity.setUpdatedAt(new Date());
			pm.makePersistent(advisorEntity);
			return prepareAdvisorDomain(advisorEntity);
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Method creates the Entity model from domain model
	 * 
	 * @param advisor
	 * @return
	 * @throws Exception
	 */
	public AdvisorEntity prepareAdvisorEntity(AdvisorCreate advisor) throws Exception {
		return new AdvisorEntity(advisor.getName(), advisor.getInfo(), false,
				false, advisor.getEmail(), validateMobileNumber(advisor.getMobileNumber()),
				advisor.getPassword(), new Date(), new Date());
	}

	/**
	 * Method lists all the advisors
	 * 
	 * @return
	 */
	public List<Advisor> list() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<AdvisorEntity> advisors = null;
		Query query = pm.newQuery(AdvisorEntity.class);
		advisors = (List<AdvisorEntity>) query.execute();
		List<Advisor> advisorList = new ArrayList<Advisor>();
		for (AdvisorEntity advisor : advisors) {
			advisorList.add(prepareAdvisorDomain(advisor));
		}
		pm.close();
		return advisorList;
	}

	/**
	 * Method converts the Advisor Entity to Domain mod
	 * 
	 * @param advisorEntity
	 * @return
	 */
	public Advisor prepareAdvisorDomain(AdvisorEntity advisorEntity) {
		return new Advisor(advisorEntity.getAdvisorId(), advisorEntity.getName(), advisorEntity.getInfo(),
				advisorEntity.isSuperAdmin(), advisorEntity.isAdvisorBlocked(), advisorEntity.getEmail(),
				advisorEntity.getMobileNumber().toString(), advisorEntity.getPassword(), advisorEntity.getCreatedAt(),
				advisorEntity.getUpdatedAt(), advisorEntity.getLastLogin());
	}

	/**
	 * Method to read the Advisor by Id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	public Advisor read(Long advisorId) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			AdvisorEntity advisorEntity = pm.getObjectById(AdvisorEntity.class, advisorId);
			if (advisorEntity != null)
				return new Advisor(advisorEntity.getAdvisorId(), advisorEntity.getName(), advisorEntity.getInfo(),
						advisorEntity.isSuperAdmin(), advisorEntity.isAdvisorBlocked(), advisorEntity.getEmail(),
						advisorEntity.getMobileNumber().toString(), advisorEntity.getPassword(),
						advisorEntity.getCreatedAt(), advisorEntity.getUpdatedAt(), advisorEntity.getLastLogin());
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Advisor not found");
		}
		catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}
		return null;

	}

	/**
	 * Method to update the advisor
	 * 
	 * @param advisor
	 * @return
	 * @throws Exception
	 */
	public Advisor update(AdvisorUpdate advisor) throws Exception {
		if (null == advisor.getId())
			throw new Exception("Advisor Id is required");
		AdvisorEntity advisorEntity = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			advisorEntity = pm.getObjectById(AdvisorEntity.class, advisor.getId());
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Advisor not found");
		}

		if (advisorEntity != null) {
			// advisorEntity.setName(advisor.getName());
			// advisorEntity.setInfo(advisor.getInfo());
			advisorEntity.setUpdatedAt(new Date());
			if (null != advisor.getEmail())
				advisorEntity.setEmail(advisor.getEmail());
			if (null != advisor.getInfo())
				advisorEntity.setInfo(advisor.getInfo());
			if (null != advisor.getMobileNumber())
				advisorEntity.setMobileNumber(validateMobileNumber(advisor.getMobileNumber()));
			if (null != advisor.getName())
				advisorEntity.setName(advisor.getName());
			if (null != advisor.getPassword())
				advisorEntity.setPassword(advisor.getPassword());
			try {
				pm.makePersistent(advisorEntity);
			} catch (Exception e) {
				throw new Exception("System error");
			}

		} else
			throw new Exception("Advisor not found");
		pm.close();
		return new Advisor(advisorEntity.getAdvisorId(), advisorEntity.getName(), advisorEntity.getInfo(),
				advisorEntity.isSuperAdmin(), advisorEntity.isAdvisorBlocked(), advisorEntity.getEmail(),
				advisorEntity.getMobileNumber().toString(), advisorEntity.getPassword(), advisorEntity.getCreatedAt(),
				advisorEntity.getUpdatedAt(), advisorEntity.getLastLogin());
	}

	/**
	 * Method blocks the Advisor
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	public Advisor block(Long advisorId) throws Exception {

		AdvisorEntity advisorEntity = null;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			advisorEntity = pm.getObjectById(AdvisorEntity.class, advisorId);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Advisor not found");
		}

		if (advisorEntity != null) {
			if (advisorEntity.isSuperAdmin()) {
				throw new Exception("Super Admin cannot be blocked");
			}
			advisorEntity.setAdvisorBlocked(true);
			advisorEntity.setUpdatedAt(new Date());
			try {
				pm.makePersistent(advisorEntity);
			} catch (Exception e) {
				throw new Exception("System error");
			}

		} else
			throw new Exception("Advisor not found");
		pm.close();
		return new Advisor(advisorEntity.getAdvisorId(), advisorEntity.getName(), advisorEntity.getInfo(),
				advisorEntity.isSuperAdmin(), advisorEntity.isAdvisorBlocked(), advisorEntity.getEmail(),
				advisorEntity.getMobileNumber().toString(), advisorEntity.getPassword(), advisorEntity.getCreatedAt(),
				advisorEntity.getUpdatedAt(), advisorEntity.getLastLogin());
	}

	/**
	 * Deleting advisor
	 * 
	 * @param advisorId
	 * @throws Exception
	 */
	public void delete(Long advisorId) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		AdvisorEntity advisorEntity = null;
		try {
			advisorEntity = pm.getObjectById(AdvisorEntity.class, advisorId);
			if (advisorEntity.isSuperAdmin()) {
				throw new Exception("Super Admin can not be deleted");
			}
			pm.deletePersistent(advisorEntity);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Advisor not found");
		}catch (Exception e) {
			throw new Exception("System error");
		}
		finally {
			pm.close();
		}
	}

	private String validateMobileNumber(String mobileNumber) throws Exception {
		Long i = null;
		if (!StringUtils.isNumeric(mobileNumber)) {
			throw new Exception("Not a valid Phone Number");
		}

		if (!(10 == mobileNumber.length())) {
			throw new Exception("Not a valid Phone Number");
		}
		return mobileNumber;
	}
}
