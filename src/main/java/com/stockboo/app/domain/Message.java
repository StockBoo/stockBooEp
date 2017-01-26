package com.stockboo.app.domain;

import com.stockboo.app.stock.domain.Stock;

/**
 * Messages
 * 
 * @author sunil.r
 *
 */
public class Message {

	private Long id;

	private String content;

	private Stock stock;

	public Message() {
	}

	/**
	 * @param id
	 * @param content
	 * @param stockId
	 * @param stockName
	 */
	public Message(Long id, String content, Stock stock) {
		super();
		this.id = id;
		this.content = content;
		this.stock = stock;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
