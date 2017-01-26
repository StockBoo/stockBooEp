package com.stockboo.app.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Database entity for stocks
 * 
 * @author sunil.r
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class StockEntity {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Index
	private Long StockId;
	
	@Persistent
	private Long advisorId;
	
	@Persistent
	private String stockName;
	
	@Persistent
	private String scriptCode;
	
	@Persistent
	@Index
	private Integer sugesstionType;// 0,1,------------------>Enums with
	
	@Persistent
	private Double buyPrice;
	
	@Persistent
	private Double stopLoss;
	
	@Persistent
	private Double targetPrice;
	
	@Persistent
	private Double bookingPrice;
	
	@Persistent
	private String message;
	
	@Index
	@Persistent
	private Integer status; // 1,---------------------------->0(open) or 1
	
	@Persistent
	private String result;
	
//	@Index
	@Persistent
	private Date createdAt;
	
	@Persistent
	private Date updatedAt;

	/**
	 * 
	 */
	public StockEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param stockName
	 * @param scriptCode
	 * @param sugesstionType
	 * @param buyPrice
	 * @param stopLoss
	 * @param targetPrice
	 * @param bookingPrice
	 * @param message
	 * @param status
	 * @param result
	 * @param createdAt
	 */
	public StockEntity(String stockName, String scriptCode, Integer sugesstionType, Double buyPrice, Double stopLoss,
			Double targetPrice, Double bookingPrice, String message, Integer status, String result,
			Date createdAt, Long advisorId ) {
		super();
		this.stockName = stockName;
		this.scriptCode = scriptCode;
		this.sugesstionType = sugesstionType;
		this.buyPrice = buyPrice;
		this.stopLoss = stopLoss;
		this.targetPrice = targetPrice;
		this.bookingPrice = bookingPrice;
		this.message = message;
		this.status = status;
		this.result = result;
		this.createdAt = createdAt;
		this.advisorId = advisorId;
	}


	/**
	 * @return the stockId
	 */
	public Long getStockId() {
		return StockId;
	}

	/**
	 * @param stockId
	 *            the stockId to set
	 */
	public void setStockId(Long stockId) {
		StockId = stockId;
	}

	/**
	 * @return the stockName
	 */
	public String getStockName() {
		return stockName;
	}

	/**
	 * @param stockName
	 *            the stockName to set
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	/**
	 * @return the scriptCode
	 */
	public String getScriptCode() {
		return scriptCode;
	}

	/**
	 * @param scriptCode
	 *            the scriptCode to set
	 */
	public void setScriptCode(String scriptCode) {
		this.scriptCode = scriptCode;
	}

	/**
	 * @return the sugesstionType
	 */
	public Integer getSugesstionType() {
		return sugesstionType;
	}

	/**
	 * @param sugesstionType
	 *            the sugesstionType to set
	 */
	public void setSugesstionType(Integer sugesstionType) {
		this.sugesstionType = sugesstionType;
	}

	/**
	 * @return the buyPrice
	 */
	public Double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice
	 *            the buyPrice to set
	 */
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	/**
	 * @return the stopLoss
	 */
	public Double getStopLoss() {
		return stopLoss;
	}

	/**
	 * @param stopLoss
	 *            the stopLoss to set
	 */
	public void setStopLoss(Double stopLoss) {
		this.stopLoss = stopLoss;
	}

	/**
	 * @return the targetPrice
	 */
	public Double getTargetPrice() {
		return targetPrice;
	}

	/**
	 * @param targetPrice
	 *            the targetPrice to set
	 */
	public void setTargetPrice(Double targetPrice) {
		this.targetPrice = targetPrice;
	}

	/**
	 * @return the bookingPrice
	 */
	public Double getBookingPrice() {
		return bookingPrice;
	}

	/**
	 * @param bookingPrice
	 *            the bookingPrice to set
	 */
	public void setBookingPrice(Double bookingPrice) {
		this.bookingPrice = bookingPrice;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt
	 *            the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt
	 *            the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the advisorId
	 */
	public Long getAdvisorId() {
		return advisorId;
	}


	/**
	 * @param advisorId the advisorId to set
	 */
	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
	}

}
