package com.org.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.app.service.TransactionService;
import com.org.app.viewModel.TransactionDetail;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@ApiOperation(value="Finds transaction detail by providing transaction id")
	@RequestMapping("/{id}")
	public ResponseEntity<TransactionDetail> findTransactionDetailsByATransactionId(@PathVariable("id") long transactionId) {
		TransactionDetail transactionDetail = transactionService.findTransactionByTransactionId(transactionId);
		if (transactionDetail != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(transactionDetail);
		else
			return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Finds all transaction details by providing account id")
	@RequestMapping("/transaction/{id}")
	public ResponseEntity<List<TransactionDetail>> findAllTransactionsByAccountId(@PathVariable("id") long accountId) {
		List<TransactionDetail> transactionDetailList = transactionService.findAllTransactionByAccountIdOrderByTimestamp(accountId);
		if (transactionDetailList != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(transactionDetailList);
		else
			return ResponseEntity.notFound().build();
	}
}
