package com.org.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.Exception.RecordNotFoundException;
import com.org.app.entity.Transaction;
import com.org.app.populate.TransactionPopulate;
import com.org.app.repository.TransactionRepository;
import com.org.app.service.TransactionService;
import com.org.app.viewModel.TransactionDetail;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TransactionPopulate transactionPopulate;

	@Override
	public TransactionDetail findTransactionByTransactionId(long transactionId) {
		Transaction transaction = transactionRepository.findById(transactionId)
				.orElseThrow(() -> new RecordNotFoundException("Transaction id " + transactionId + " is not present."));
		return transactionPopulate.populateTransactionDetail(transaction);
	}

	@Override
	public List<TransactionDetail> findAllTransactionByAccountIdOrderByTimestamp(long accountId) {
		List<Transaction> transactions = transactionRepository.findByAccountAccountIDOrderByTimestampAsc(accountId).
				orElseThrow(() -> new RecordNotFoundException("Account id " + accountId + " is not present."));
		List<TransactionDetail> transactionDetails = new ArrayList<TransactionDetail>();
		for (Transaction transaction : transactions) {
			transactionDetails.add(transactionPopulate.populateTransactionDetail(transaction));
		}
		return transactionDetails;
	}

}
