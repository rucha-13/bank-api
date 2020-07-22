package com.org.app.service;

import com.org.app.viewModel.CustomerDetail;

public interface CustomerService {
	public CustomerDetail findCustomerByCustomerId(Long customerId) throws Exception;
}
