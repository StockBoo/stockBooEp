package com.stockboo.app.domain;

public class StockBoo {
	private Integer stockBooId;
	private String userName;
	
	public StockBoo(Integer id,String name){
		this.stockBooId = id;
		this.userName = name;
	}
	/**
	 * @return the stockBooId
	 */
	public Integer getStockBooId() {
		return stockBooId;
	}
	/**
	 * @param stockBooId the stockBooId to set
	 */
	public void setStockBooId(Integer stockBooId) {
		this.stockBooId = stockBooId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
