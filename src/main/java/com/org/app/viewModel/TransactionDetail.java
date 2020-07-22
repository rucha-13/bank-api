package com.org.app.viewModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Details about transaction")
public class TransactionDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long transacionId;

	private AccountDetail account;
	
	private String type;
	
	private String description;
	
	private BigDecimal amount;
	
	private String currencyCode;
	
	private Date timestamp;

	public TransactionDetail() {
		
	}

	public long getTransacionId() {
		return transacionId;
	}

	public void setTransacionId(long transacionId) {
		this.transacionId = transacionId;
	}

	public AccountDetail getAccount() {
		return account;
	}

	public void setAccount(AccountDetail account) {
		this.account = account;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
