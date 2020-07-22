package com.org.app.service;

import java.util.List;

import com.org.app.viewModel.TransactionDetail;

public interface TransactionService {

	public TransactionDetail findTransactionByTransactionId(long transactionId);
	public List<TransactionDetail> findAllTransactionByAccountIdOrderByTimestamp(long accountId);
	
}
