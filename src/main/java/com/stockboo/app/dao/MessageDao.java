package com.stockboo.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.stockboo.app.YourFirstAPI;
import com.stockboo.app.domain.Message;
import com.stockboo.app.domain.MessageCreate;
import com.stockboo.app.entity.MessageEntity;
import com.stockboo.app.stock.domain.Stock;

/**
 * Dao class for messages create, delete
 * 
 * @author sunil.r
 *
 */
public class MessageDao {
	
	private static final Logger log = Logger.getLogger(YourFirstAPI.class.getName());

	/**
	 * Creates stock
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public Message create(MessageCreate message) throws Exception {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		StockDao sdao = new StockDao();
		MessageEntity messageEntity = null;
		Stock stock = null;
		/*if (null == message.getStockId()) {
			throw new Exception("Stock Id is required");
		}*/
		try {
			stock = sdao.read(message.getStockId());
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Stock not found");
		} catch (Exception e) {
			log.info(e.toString());
			throw new Exception("System error");
		}
		messageEntity = new MessageEntity(message.getContent(), message.getStockId(), stock.getName());
		// messageEntity = new MessageEntity(message.getContent(), null, null);
		messageEntity.setCreatedAt(new Date().getTime());
		try {
			pm.makePersistent(messageEntity);
			return prepareMessageDomain(messageEntity);
		} catch (Exception e) {
			throw new Exception("System error");
		} finally {
			pm.close();
		}

	}

	/**
	 * Deletes the stock based on the id
	 * 
	 * @param stockId
	 * @throws Exception
	 */
	public void delete(Long messageId) throws Exception {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		MessageEntity messageEntity = null;
		try {
			messageEntity = pm.getObjectById(MessageEntity.class, messageId);
			pm.deletePersistent(messageEntity);
		} catch (javax.jdo.JDOObjectNotFoundException e) {
			throw new Exception("Message not found");
		} catch (Exception e) {
			log.info(e.toString());
			throw new Exception("System error");
		} finally {
			pm.close();
		}
	}

	/**
	 * Lists all the Messages
	 * 
	 * @return
	 */
	public List<Message> list(Long stockId, Long messageSize) {
		PersistenceManager pm = PMF.get().getPersistenceManager();

		/*
		 * QueryOptions options = QueryOptions.newBuilder() .setLimit(10)
		 * .build();
		 * 
		 * // A query string String queryString =
		 * "product: coffee roaster AND price < 500";
		 * 
		 * // Build the Query and run the search
		 * com.google.appengine.api.search.Query query =
		 * com.google.appengine.api.search.Query.newBuilder().setOptions(options
		 * ).build(queryString); IndexSpec indexSpec =
		 * IndexSpec.newBuilder().setName(indexName).build(); Index index =
		 * SearchServiceFactory.getSearchService().getIndex(indexSpec);
		 * Results<ScoredDocument> result = index.search(query); return result;
		 */
		/*
		 * if(null==stockId){ List<MessageEntity> results = null; Query query =
		 * pm.newQuery(MessageEntity.class); results = (List<MessageEntity>)
		 * query.execute(); List<Message> messageList = new
		 * ArrayList<Message>(); for (MessageEntity messageEntity : results) {
		 * messageList.add(prepareMessageDomain(messageEntity)); }
		 * 
		 * }else{
		 */
		/*
		 * DatastoreService datastore =
		 * DatastoreServiceFactory.getDatastoreService();
		 * com.google.appengine.api.datastore.Query q=null; if(null!=stockId){
		 * Filter propertyFilter = new FilterPredicate("stockId",
		 * FilterOperator.EQUAL, stockId); q = new
		 * com.google.appengine.api.datastore.Query("MessageEntity")
		 * .setFilter(propertyFilter);.addSort("messageId",
		 * SortDirection.DESCENDING); }else { q = new
		 * com.google.appengine.api.datastore.Query("MessageEntity");.addSort(
		 * "messageId", SortDirection.DESCENDING);} if (
		 * 0==messageSize)messageSize =10; List<Entity> results1 =
		 * datastore.prepare(q).asList(FetchOptions.Builder.withLimit(
		 * messageSize)); List<Message> messageList = new ArrayList<Message>();
		 * for (Entity en : results1) { messageList.add(prepareDomain(en)); }
		 * return results1;
		 */
		// }
		// return null;
		try {

			List<MessageEntity> results = null;
			Query query = pm.newQuery(MessageEntity.class);
			// List<MessageEntity> result = (List<MessageEntity>)
			// query.execute();
			// int i = result.size();
			if (null == messageSize) {
				messageSize = 10L;
			}
			Query query1 = pm.newQuery(MessageEntity.class);
			if (null != stockId) {
				query1.setFilter("this.stockId == stockId");
				query1.declareParameters("Long stockId");
				query1.setOrdering("createdAt desc");
				query1.setRange(0, messageSize);
				results = (List<MessageEntity>) query1.execute(stockId);
				System.out.println(query1);
				log.info(query1.toString());
			} else {
				// desc for descending
				query1.setOrdering("createdAt desc");
				query1.setRange(0, messageSize);
				log.info(query1.toString());
				results = (List<MessageEntity>) query1.execute();
				log.info(results.toString());
			}
			List<Message> messageList = new ArrayList<Message>();
			for (MessageEntity messageEntity : results) {
				messageList.add(prepareMessageDomain(messageEntity));
			}

			return messageList;
		} catch (Exception e) {
			log.info(e.toString());
			return null;
		}

	}

	/*private Message prepareDomain(Entity en) {
		
		return new Message(Long.parseLong(en.getProperty("messageId").toString()), en.getProperty("content").toString(),
				Long.parseLong(en.getProperty("stockId").toString()), en.getProperty("stockName").toString());
	}*/

	/*
	 * Converts entity to domain
	 */
	private Message prepareMessageDomain(MessageEntity messageEntity) {
		Stock stock = new Stock();
		stock.setId(messageEntity.getStockId());
		stock.setName(messageEntity.getStockName());
		return new Message(messageEntity.getMessageId(), messageEntity.getContent(), stock);
	}

}
