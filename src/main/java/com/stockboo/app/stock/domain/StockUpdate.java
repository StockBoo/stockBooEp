package com.stockboo.app.stock.domain;

/**
 * DTO for Installation JSON
 * 
 * @author sunil.r
 *
 */
public class StockUpdate {

	private Long id;
	private Long advisorId;
	private String name;
	private String scriptCode;
	private SugesstionType sugesstionType;// 0,1,------------------>Enums with
											// small term, long term
	private Double buyPrice;
	private Double stopLoss;
	private Double targetPrice;
	private Double bookingPrice;
	private String message;
	private Status status; // 1,---------------------------->0(open) or 1
	private String result;

	/**
	 * 
	 */
	public StockUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
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
	 * @param updatedAt
	 * @param lastLogin
	 */
	public StockUpdate(Long id, String name, String scriptCode, SugesstionType sugesstionType,
			Double buyPrice, Double stopLoss, Double targetPrice, Double bookingPrice, String message,
			Status status, String result) {
		super();
		this.id = id;
		this.name = name;
		this.scriptCode = scriptCode;
		this.sugesstionType = sugesstionType;
		this.buyPrice = buyPrice;
		this.stopLoss = stopLoss;
		this.targetPrice = targetPrice;
		this.bookingPrice = bookingPrice;
		this.message = message;
		this.status = status;
		this.result = result;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the scriptCode
	 */
	public String getScriptCode() {
		return scriptCode;
	}

	/**
	 * @param scriptCode the scriptCode to set
	 */
	public void setScriptCode(String scriptCode) {
		this.scriptCode = scriptCode;
	}

	/**
	 * @return the sugesstionType
	 */
	public SugesstionType getSugesstionType() {
		return sugesstionType;
	}

	/**
	 * @param sugesstionType the sugesstionType to set
	 */
	public void setSugesstionType(SugesstionType sugesstionType) {
		this.sugesstionType = sugesstionType;
	}

	/**
	 * @return the buyPrice
	 */
	public Double getBuyPrice() {
		return buyPrice;
	}

	/**
	 * @param buyPrice the buyPrice to set
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
	 * @param stopLoss the stopLoss to set
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
	 * @param targetPrice the targetPrice to set
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
	 * @param bookingPrice the bookingPrice to set
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
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	
	
}
