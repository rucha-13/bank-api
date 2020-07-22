package com.org.app.viewModel;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Details about account")
public class AccountDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long accountID;
	
	private CustomerDetail customer;
	
	private String type;
	
	private long accountNumber;
	
	private String iban;
	
	private String status;
	
	private BigDecimal balance;
	
	private String currencyCode;

	public AccountDetail() {
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	public CustomerDetail getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDetail customer) {
		this.customer = customer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	
}
