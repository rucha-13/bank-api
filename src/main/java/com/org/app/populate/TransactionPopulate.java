package com.org.app.populate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.app.entity.Transaction;
import com.org.app.viewModel.AccountDetail;
import com.org.app.viewModel.TransactionDetail;

@Component
public class TransactionPopulate {

	@Autowired
	private AccountPopulate accountPopulate;
	
	public TransactionDetail populateTransactionDetail(Transaction transaction) {
		TransactionDetail transactionDetail = new TransactionDetail();
		AccountDetail accountDetail = accountPopulate.populateAccountDetail(transaction.getAccount());
		transactionDetail.setAccount(accountDetail);
		transactionDetail.setAmount(transaction.getAmount());
		transactionDetail.setCurrencyCode(transaction.getCurrencyCode());
		transactionDetail.setDescription(transaction.getDescription());
		transactionDetail.setTimestamp(transaction.getTimestamp());
		transactionDetail.setTransacionId(transaction.getTransactionId());
		transactionDetail.setType(transaction.getType());
		return transactionDetail;
	}
}
