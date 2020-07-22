package com.org.app.populate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.app.entity.Account;
import com.org.app.viewModel.AccountDetail;
import com.org.app.viewModel.CustomerDetail;

@Component
public class AccountPopulate {
	
	@Autowired
	private CustomerPopulate customerPopulate;
	
	public AccountDetail populateAccountDetail(Account account) {
		AccountDetail accountDetail = new AccountDetail();
		accountDetail.setAccountID(account.getAccountID());
		accountDetail.setAccountNumber(account.getAccountNumber());
		accountDetail.setBalance(account.getBalance());
		accountDetail.setCurrencyCode(account.getCurrencyCode());
		CustomerDetail customerDetail = customerPopulate.populateCustomerDetail(account.getCustomer());
		accountDetail.setCustomer(customerDetail);
		accountDetail.setIban(account.getIban());
		accountDetail.setStatus(account.getStatus());
		accountDetail.setType(account.getType());
		return accountDetail;
	}

}
