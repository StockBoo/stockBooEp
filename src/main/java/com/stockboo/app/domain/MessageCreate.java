package com.stockboo.app.domain;

import javax.validation.constraints.NotNull;

/**
 * Messages
 * 
 * @author sunil.r
 *
 */
public class MessageCreate {

	@NotNull
	private String content;
	
	private Long stockId;

	public MessageCreate() {
	}

	/**
	 * @param content
	 * @param stockId
	 * @param stockName
	 */
	public MessageCreate(String content, Long stockId) {
		super();
		this.content = content;
		this.stockId = stockId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the stockId
	 */
	public Long getStockId() {
		return stockId;
	}

	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}


}
