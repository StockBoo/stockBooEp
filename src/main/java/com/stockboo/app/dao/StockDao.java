package com.stockboo.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.stockboo.app.domain.Advisor;
import com.stockboo.app.entity.AdvisorEntity;
import com.stockboo.app.entity.StockEntity;
import com.stockboo.app.stock.domain.Status;
import com.stockboo.app.stock.domain.Stock;
import com.stockboo.app.stock.domain.StockCreate;
import com.stockboo.app.stock.domain.StockUpdate;
import com.stockboo.app.stock.domain.SugesstionType;

/**
 * Dao class for stocks create, update, read, delete
 * 
 * @author sunil.r
 *
 */
public class StockDao {

	String comma = ",";

	/**
	 * Creates stock
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public Stock create(StockCreate s) throws Exception {
		if (null == s.getAdvisorId())
			throw new Exception("Advisor Id is required");
		AdvisorDao adao = new AdvisorDao();
		Advisor a = adao.read(s.getAdvisorId());
		if (null == a) {
			throw new Exception("Advisor not found");
		}
		PersistenceManager pm = PMF.get().getPersistenceManager();
		StockEntity entity = prepareEntity(s);

		try {
			entity.setCreatedAt(new Date());
			entity.setUpdatedAt(new Date());
			pm.makePersistent(entity);
			return prepareStockDomain(entity, a);
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Reads the stock based on the id.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Stock read(Long id) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			StockEntity entity = pm.getObjectById(StockEntity.class, id);
			AdvisorDao adao = new AdvisorDao();
			Advisor a = adao.read(entity.getAdvisorId());
			if (null != entity)
				return prepareStockDomain(entity, a);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Stock not found");
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}
		return null;

	}

	/**
	 * Updates the stock details.
	 * 
	 * @param stock
	 * @return
	 * @throws Exception
	 */
	public Stock update(StockUpdate stock) throws Exception {
		if (null == stock.getId())
			throw new Exception("Stock Id is required");
		if (null == stock.getAdvisorId())
			throw new Exception("Advisor Id is required");
		AdvisorDao adao = new AdvisorDao();
		Advisor a = adao.read(stock.getAdvisorId());
		if (null == a) {
			throw new Exception("Advisor not found");
		}
		PersistenceManager pm = PMF.get().getPersistenceManager();
		StockEntity entity = null;
		try {
			entity = pm.getObjectById(StockEntity.class, stock.getId());
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Stock not found");
		}
		if (null != stock.getBookingPrice())
			entity.setBookingPrice(stock.getBookingPrice());
		if (null != stock.getBuyPrice())
			entity.setBuyPrice(stock.getBuyPrice());
		// Write another api which updates only lastlogin
		if (null != stock.getResult())
			entity.setResult(stock.getResult());
		if (null != stock.getMessage())
			entity.setMessage(stock.getMessage());
		if (null != stock.getScriptCode())
			entity.setScriptCode(stock.getScriptCode());
		if (null != stock.getStatus())
			entity.setStatus(stock.getStatus().getStatuscode());
		if (null != stock.getStopLoss())
			entity.setStopLoss(stock.getStopLoss());
		if (null != stock.getSugesstionType())
			entity.setSugesstionType(stock.getSugesstionType().getSugesstionTypecode());
		if (null != stock.getTargetPrice())
			entity.setTargetPrice(stock.getTargetPrice());
		entity.setUpdatedAt(new Date());

		try {
			pm.makePersistent(stock);
		} catch (Exception e) {
			throw new Exception("System error");
		}

		return prepareStockDomain(entity, a);

	}

	/**
	 * Deletes the stock based on the id
	 * 
	 * @param stockId
	 * @throws Exception
	 */
	public void delete(Long stockId) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			StockEntity stockEntity = pm.getObjectById(StockEntity.class, stockId);
			AdvisorEntity advisorEntity = pm.getObjectById(AdvisorEntity.class, stockEntity.getAdvisorId());
			if (!advisorEntity.isSuperAdmin()) {
				throw new Exception("You are not authorized to delete");
			}
			pm.deletePersistent(stockEntity);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Stock not found");
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}
	}

	/**
	 * Lists all the Stocks based on the filters
	 * 
	 * @return
	 */
	public List<Stock> listwithfilters(SugesstionType sugesstionType, Status status, Date recordsFrom, Long stockId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Stock> stockList = new ArrayList<Stock>();
		/*
		 * Query query = pm.newQuery(StockEntity.class); results =
		 * (List<StockEntity>) query.execute(); List<Stock> stockList = new
		 * ArrayList<Stock>(); for (StockEntity stockEntity : results) {
		 * stockList.add(prepareStockDomain(stockEntity)); }
		 */
		String queryString = "";
		String declaredParams = "";
		Map args = new HashMap();

		if (null != stockId) {
			queryString = queryString + "this.StockId == stockId";
			declaredParams = "Long stockId";
			args.put("stockId", stockId);
		}
		if (null != sugesstionType) {
			if ("" != queryString && "" != declaredParams) {
				queryString = queryString + "&& " + " this.sugesstionType == sugesstionType";
				declaredParams = declaredParams + comma + " Integer sugesstionType";
			} else {
				queryString = queryString + " this.sugesstionType == sugesstionType";
				declaredParams = declaredParams + "Integer sugesstionType";
			}
			args.put("sugesstionType", sugesstionType.getSugesstionTypecode());
		}
		if (null != status) {

			if ("" != queryString && "" != declaredParams) {
				queryString = queryString + " && " + " this.status == status";
				declaredParams = declaredParams + comma + " Integer status";
			} else {
				queryString = queryString + " this.status == status";
				declaredParams = declaredParams + "Integer status";
			}
			args.put("status", status.getStatuscode());
		}
		if (null != recordsFrom) {

			if ("" != queryString && "" != declaredParams) {
				queryString = queryString + " && " + " this.createdAt <= createdAt";
				declaredParams = declaredParams + comma + " java.util.Date createdAt";
			} else {
				queryString = queryString + " this.createdAt <= createdAt ";
				declaredParams = declaredParams + "java.util.Date createdAt";
			}
			// queryString= "&&" +" this.createdAt > null";
			// declaredParams = comma+ " java.util.Date createdAt";
			args.put("createdAt", recordsFrom);
		}
		/*
		 * String query=""; if(null!=sugesstionType) query =
		 * "sugesstionType=="+sugesstionType.getSugesstionTypecode()+" && ";
		 * if(null!=status) query = query+
		 * " status=="+Status.values()[status.getStatuscode()]+" && ";
		 * if(null!=recordsFrom){ query = query + "createdAt=="+recordsFrom; //
		 * query = query +
		 * " StockEntity.createdAt <= datetime('"+recordsFrom+"')";
		 * 
		 * }
		 */
		Query q = pm.newQuery(StockEntity.class, queryString);
		System.out.println("****************** printinh querystring");
		System.out.println(queryString);
		q.declareParameters(declaredParams);
		System.out.println("********************** printing declaredparams");
		System.out.println(declaredParams);
		List<StockEntity> results = (List<StockEntity>) q.executeWithMap(args);
		System.out.println("**********************************");
		System.out.println(q);
		AdvisorDao adao = new AdvisorDao();
		List<Advisor> a = adao.list();
		Map<Long, Advisor> advisorMap = new HashMap<Long, Advisor>();
		for (Advisor advisor : a) {
			advisorMap.put(advisor.getId(), advisor);
		}
		for (StockEntity stockEntity : results) {
			stockList.add(prepareStockDomain(stockEntity, advisorMap.get(stockEntity.getAdvisorId())));
		}
		return stockList;
	}

	/**
	 * Lists all the Stocks
	 * 
	 * @return
	 */
	/*
	 * public List<Stock> list() { PersistenceManager pm =
	 * PMF.get().getPersistenceManager(); List<Stock> stockList = new
	 * ArrayList<Stock>(); Query query = pm.newQuery(StockEntity.class);
	 * List<StockEntity> results = (List<StockEntity>) query.execute(); for
	 * (StockEntity stockEntity : results) {
	 * stockList.add(prepareStockDomain(stockEntity)); }
	 * 
	 * return stockList; }
	 */

	/*
	 * Prepares domain object from entity
	 */
	private Stock prepareStockDomain(StockEntity stockEntity, Advisor a) {
		Stock s = new Stock();
		s.setBookingPrice(stockEntity.getBookingPrice());
		s.setBuyPrice(stockEntity.getBuyPrice());
		s.setCreatedAt(stockEntity.getCreatedAt());
		s.setMessage(stockEntity.getMessage());
		s.setScriptCode(stockEntity.getScriptCode());
		s.setResult(stockEntity.getResult());
		s.setName(stockEntity.getStockName());
		s.setStopLoss(stockEntity.getStopLoss());
		s.setUpdatedAt(stockEntity.getUpdatedAt());
		s.setStatus(Status.values()[stockEntity.getStatus()]);
		s.setSugesstionType(SugesstionType.values()[stockEntity.getSugesstionType()]);
		s.setTargetPrice(stockEntity.getTargetPrice());
		s.setId(stockEntity.getStockId());
		com.stockboo.app.stock.domain.Advisor advisor = new com.stockboo.app.stock.domain.Advisor();
		advisor.setId(a.getId());
		advisor.setName(a.getName());
		s.setAdvisor(advisor);
		return s;
	}

	/*
	 * .g\ Prepares entity object from domain
	 */
	private StockEntity prepareEntity(StockCreate stock) {
		return new StockEntity(stock.getName(), stock.getScriptCode(),
				stock.getSugesstionType().getSugesstionTypecode(), stock.getBuyPrice(), stock.getStopLoss(),
				stock.getTargetPrice(), stock.getBookingPrice(), stock.getMessage(), stock.getStatus().getStatuscode(),
				stock.getResult(), new Date(), stock.getAdvisorId());
	}

}
