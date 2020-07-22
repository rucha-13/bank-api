package com.org.app.service;

import com.org.app.viewModel.AccountDetail;

public interface AccountService {

	public AccountDetail findAccountByAccountId(long accountId);
	
}
