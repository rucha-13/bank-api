package com.org.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.app.service.AccountService;
import com.org.app.viewModel.AccountDetail;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(name="/accounts",produces="application/json")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@ApiOperation(value="Finds account details by accountId")
	@RequestMapping("/{id}")
	public ResponseEntity<AccountDetail> findAccountDetailsByAccountId(@PathVariable("id") long accountId) {
		AccountDetail accountDetail = accountService.findAccountByAccountId(accountId);
		
		if (accountDetail != null)
			return ResponseEntity.status(HttpStatus.FOUND).body(accountDetail);
		else
			return ResponseEntity.notFound().build();
	}
	
}
