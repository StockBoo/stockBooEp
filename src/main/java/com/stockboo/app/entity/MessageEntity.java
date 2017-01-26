package com.stockboo.app.entity;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Messages
 * 
 * @author sunil.r
 *
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MessageEntity {

	@PrimaryKey
	@Index
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long messageId;

	@Persistent
	@Index
	private String content;

	@Persistent
	@Index
	private Long stockId;

	@Persistent
	@Index
	private String stockName;

	@Persistent
	private long createdAt;

	public MessageEntity() {
	}

	/**
	 * @param messageId
	 * @param content
	 * @param stockId
	 * @param stockName
	 */
	public MessageEntity(String content, Long stockId, String stockName) {
		super();
		this.content = content;
		this.stockId = stockId;
		this.stockName = stockName;
	}

	/**
	 * @return the messageId
	 */
	public Long getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
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
	 * @return the stockId
	 */
	public Long getStockId() {
		return stockId;
	}

	/**
	 * @param stockId
	 *            the stockId to set
	 */
	public void setStockId(Long stockId) {
		this.stockId = stockId;
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
	 * @return the createdAt
	 */
	public long getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param l the createdAt to set
	 */
	public void setCreatedAt(long l) {
		this.createdAt = l;
	}

}
