package com.stockboo.app;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.stockboo.app.configuration.Constants;
import com.stockboo.app.dao.AdvisorDao;
import com.stockboo.app.dao.AppAuthenticationDao;
import com.stockboo.app.dao.InstallDao;
import com.stockboo.app.dao.MessageDao;
import com.stockboo.app.dao.StockDao;
import com.stockboo.app.domain.Advisor;
import com.stockboo.app.domain.AdvisorCreate;
import com.stockboo.app.domain.AdvisorUpdate;
import com.stockboo.app.domain.Install;
import com.stockboo.app.domain.InstallCreate;
import com.stockboo.app.domain.InstallUpdate;
import com.stockboo.app.domain.Message;
import com.stockboo.app.domain.MessageCreate;
import com.stockboo.app.domain.NewToken;
import com.stockboo.app.domain.RefreshOutput;
import com.stockboo.app.stock.domain.Status;
import com.stockboo.app.stock.domain.Stock;
import com.stockboo.app.stock.domain.StockCreate;
import com.stockboo.app.stock.domain.StockUpdate;
import com.stockboo.app.stock.domain.SugesstionType;

/**
 * Add your first API methods in this class, or you may create another class. In
 * that case, please update your web.xml accordingly.
 **/
@Api(name = "stockboo", version = "v1", description = "Stockboo cloud-endpoint"/*
																				 * ,
																				 * clientIds
																				 * =
																				 * {Constants
																				 * .
																				 * WEB_CLIENT_ID,
																				 * Constants
																				 * .
																				 * ANDROID_CLIENT_ID,
																				 * Constants
																				 * .
																				 * IOS_CLIENT_ID}
																				 */)
public class YourFirstAPI {
	
	private static final Logger log = Logger.getLogger(YourFirstAPI.class.getName());

	/**
	 * Reads the installation based on installation id
	 * 
	 * @param installationsID
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "installations.read", path = "installations/read", httpMethod = ApiMethod.HttpMethod.GET)
	public Install installationRead(HttpServletRequest req, @Nullable @Named("installationsID") Long installationsID) throws Exception {
		authentication(req);
		InstallDao idao = new InstallDao();
		Install i = idao.read(installationsID);
		return i;
	}

	/**
	 * Creates the installation
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "installations.create", path = "installations/create", httpMethod = ApiMethod.HttpMethod.POST)
	public Install installationCreate(InstallCreate i) throws Exception {
		System.out.println("Test executed successfully with " + i);
		InstallDao idao = new InstallDao();
		// Long createdId = idao.create(i);
		// if (null != createdId || 0 != createdId) {
		// Install io = new Install();
		// io.setInstallationId(createdId);
		// return io;
		// } else
		return idao.create(i);
	}

	/**
	 * Lists all the installations
	 * 
	 * @return List<Install>
	 * @throws Exception 
	 */
	@ApiMethod(name = "installations.list", path = "installations/list", httpMethod = ApiMethod.HttpMethod.GET)
	public List<Install> installationList(HttpServletRequest req) throws Exception {
		authentication(req);
		InstallDao idao = new InstallDao();
		List<Install> installList = idao.list();
		if (null != installList) {
			return installList;
		} else
			return null;

	}

	/**
	 * Updates the installation details
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "installations.update", path = "installations/update", httpMethod = ApiMethod.HttpMethod.POST)
	public Install installationUpdate(HttpServletRequest req, InstallUpdate i) throws Exception {
		authentication(req);
		System.out.println("Test executed successfully with " + i);
		InstallDao idao = new InstallDao();
		Long createdId = idao.update(i);
		if (null != createdId || 0 != createdId) {
			Install io = new Install();
			io.setInstallationId(createdId);
			return io;
		} else
			return null;

	}

	/**
	 * Method to create a new advisor from client
	 * 
	 * @param advisor
	 *            advisor
	 * @return Advisor
	 * @throws Exception
	 */
	@ApiMethod(name = "advisors.create", path = "advisors/create", httpMethod = ApiMethod.HttpMethod.POST)
	public Advisor advisorCreate(AdvisorCreate advisor) throws Exception {
		System.out.println("Advisor successfully created with " + advisor);
		AdvisorDao advisorDao = new AdvisorDao();
		if (advisor != null) {
			return advisorDao.create(advisor);
		} else {
			return null;
		}
	}

	/**
	 * Lists all the advisors present in DB
	 * 
	 * @return
	 * @throws Exception 
	 */
	@ApiMethod(name = "advisors.list", path = "advisors/list", httpMethod = ApiMethod.HttpMethod.GET)
	public List<Advisor> advisorList() throws Exception {
		System.out.println("Advisors list successfully retrieved");
		AdvisorDao advisorDao = new AdvisorDao();
		return advisorDao.list();
	}

	/**
	 * Method to read the Advisor from the advisor id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "advisors.read", path = "advisors/read", httpMethod = ApiMethod.HttpMethod.GET)
	public Advisor advisorRead(@Nullable @Named("advisorId") Long advisorId) throws Exception {
		System.out.println("Advisor red successfully with id " + advisorId);
		AdvisorDao advisorDao = new AdvisorDao();
		return advisorDao.read(advisorId);
	}

	/**
	 * Method updates the advisor
	 * 
	 * @param advisor
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "advisors.update", path = "advisors/update", httpMethod = ApiMethod.HttpMethod.POST)
	public Advisor advisorUpdate(AdvisorUpdate advisor) throws Exception {
		System.out.println("Advisor successfully updated for " + advisor.getId());
		AdvisorDao advisorDao = new AdvisorDao();
		return advisorDao.update(advisor);
	}

	/**
	 * Method blocks the advisor by using the advisor id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "advisors.block", path = "advisors/block", httpMethod = ApiMethod.HttpMethod.PUT)
	public Advisor advisorBlock( @Nullable @Named("advisorId") Long advisorId) throws Exception {
		System.out.println("Advisor successfully blocked for " + advisorId);
		AdvisorDao advisorDao = new AdvisorDao();
		return advisorDao.block(advisorId);
	}

	/**
	 * Method deletes the advisor by using the advisor id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "advisors.delete", path = "advisors/delete", httpMethod = ApiMethod.HttpMethod.DELETE)
	public void advisorDelete( @Nullable @Named("advisorId") Long advisorId) throws Exception {
		System.out.println("Advisor successfully deleted for " + advisorId);
		AdvisorDao advisorDao = new AdvisorDao();
		advisorDao.delete(advisorId);
	}

	/**
	 * Creates the Stock
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "stocks.create", path = "stocks/create", httpMethod = ApiMethod.HttpMethod.POST)
	public Stock stockCreate(HttpServletRequest req, StockCreate i) throws Exception {
		log.info(i.getAdvisorId().toString());
		log.info(i.getName());
		authentication(req);
		StockDao sdao = new StockDao();
		return sdao.create(i);
	}

	/**
	 * Updates the Stock
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "stocks.update", path = "stocks/update", httpMethod = ApiMethod.HttpMethod.POST)
	public Stock stockUpdate(HttpServletRequest req, StockUpdate s) throws Exception {
		authentication(req);
		StockDao sdao = new StockDao();
		Stock existingStock = sdao.read(s.getId());
		if (existingStock.getAdvisor().getId() != s.getAdvisorId())
			throw new Exception("You are not authorized to update the stock");
		return sdao.update(s);
	}

	/**
	 * Method deletes the Stock by using the stock id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "stocks.delete", path = "stocks/delete", httpMethod = ApiMethod.HttpMethod.DELETE)
	public void stockDelete(HttpServletRequest req, @Named("stockId") Long stockId) throws Exception {
		authentication(req);
		StockDao stockDao = new StockDao();
		stockDao.delete(stockId);
	}

	/**
	 * Lists all the stocks
	 * 
	 * @return List<Stock>
	 * @throws Exception 
	 */
	@ApiMethod(name = "stocks.list", path = "stocks/list", httpMethod = ApiMethod.HttpMethod.GET)
	public List<Stock> stockListWithFilters(HttpServletRequest req, @Nullable @Named("sugesstionType") SugesstionType sugesstionType,
			@Nullable @Named("status") Status status, @Nullable @Named("fromDate") Date recordsFrom,
			@Nullable @Named("stockId") Long stockId) throws Exception {
		authentication(req);
		System.out.println("************************ Printing the date");
		System.out.println(recordsFrom);
		StockDao stockDao = new StockDao();
		List<Stock> stockList = stockDao.listwithfilters(sugesstionType, status, recordsFrom, stockId);
		if (null != stockList) {
			return stockList;
		} else
			return null;

	}

	/**
	 * Lists all the stocks
	 * 
	 * @return List<Stock>
	 *//*
		 * @ApiMethod(name = "stocks.list", path = "stocks/list", httpMethod =
		 * ApiMethod.HttpMethod.GET) public List<Stock> stockList() { StockDao
		 * stockDao = new StockDao(); List<Stock> stockList = stockDao.list();
		 * if (null != stockList) { return stockList; } else return null;
		 * 
		 * }
		 */

	/**
	 * Creates the messages
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "messages.create", path = "messages/create", httpMethod = ApiMethod.HttpMethod.POST)
	public Message messageCreate(HttpServletRequest req, MessageCreate message) throws Exception {
		authentication(req);
		MessageDao mdao = new MessageDao();
		return mdao.create(message);
	}

	/**
	 * Method deletes the Stock by using the stock id
	 * 
	 * @param advisorId
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "messages.delete", path = "messages/delete", httpMethod = ApiMethod.HttpMethod.DELETE)
	public void messageDelete(HttpServletRequest req, @Named("messageId") Long messageId) throws Exception {
		authentication(req);
		MessageDao mdao = new MessageDao();
		mdao.delete(messageId);
	}

	/**
	 * Lists all the messages
	 * 
	 * @return List<Message>
	 * @throws Exception 
	 */
	@ApiMethod(name = "messages.list", path = "messages/list", httpMethod = ApiMethod.HttpMethod.GET)
	public List<Message> messageList(HttpServletRequest req, @Nullable @Named("stockId") Long stockId,
			@Nullable @Named("count") Long messageSize) throws Exception {
		authentication(req);
		MessageDao mdao = new MessageDao();
		List<Message> messageList = mdao.list(stockId, messageSize);
		if (null != messageList) {
			return messageList;
		} else
			return null;

	}
	
	/**
	 * Method updates the auth token
	 * 
	 * @param installation ID
	 * @return
	 * @throws Exception
	 */
	@ApiMethod(name = "auth.tokenupdate", path = "auth/tokenupdate", httpMethod = ApiMethod.HttpMethod.GET)
	public NewToken tokenUpdate(@NotNull @Named("installationId") Long installationId, @NotNull @Named("token") String token) throws Exception {
		AppAuthenticationDao auth = new AppAuthenticationDao();
		NewToken newToken = new NewToken(auth.update(installationId, token));
		return newToken;
	}
	
	/**
	 * Method updates the refresh date
	 * 
	 * @param installation ID, token
	 * @return
	 * @throws Exception
	 * 
	 */
	@ApiMethod(name = "auth.refresh", path = "auth/refresh", httpMethod = ApiMethod.HttpMethod.GET)
	public RefreshOutput refresh(@NotNull @Named("installationId") Long installationId, @NotNull @Named("token") String token) throws Exception {
		AppAuthenticationDao auth = new AppAuthenticationDao();
		RefreshOutput ro = new RefreshOutput();
		boolean flag;
		try{
			flag = auth.refresh(installationId, token);
		}catch (Exception e){
			flag = false;
		}
		ro.setRefreshed(flag);
		return ro;
		
		
	}
	
	private void authentication(HttpServletRequest req) throws Exception {
		String token = req.getHeader(Constants.AUTH_TOKEN);
		System.out.println(req.getHeader(Constants.AUTH_TOKEN));
		String installationId = req.getHeader(Constants.INSTALLATION_ID);
		System.out.println(req.getHeader(Constants.INSTALLATION_ID));
		AppAuthenticationDao auth = new AppAuthenticationDao();
		try {
			auth.checkRefreshValidity(Long.parseLong(installationId), token);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new Exception("Unable to parse the header");
		} 
	}
}
