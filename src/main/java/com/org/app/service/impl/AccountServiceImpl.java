package com.org.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.Exception.RecordNotFoundException;
import com.org.app.entity.Account;
import com.org.app.populate.AccountPopulate;
import com.org.app.repository.AccountRepository;
import com.org.app.service.AccountService;
import com.org.app.viewModel.AccountDetail;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountPopulate accountPopulate;
	
	@Override
	public AccountDetail findAccountByAccountId(long accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(() ->new RecordNotFoundException("Account id "+ accountId + " is not present. "));
		return accountPopulate.populateAccountDetail(account);
	}	


}
