package com.org.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.Exception.RecordNotFoundException;
import com.org.app.entity.Customer;
import com.org.app.populate.CustomerPopulate;
import com.org.app.repository.CustomerRepository;
import com.org.app.service.CustomerService;
import com.org.app.viewModel.CustomerDetail;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerPopulate populate;
	
	@Override
	public CustomerDetail findCustomerByCustomerId(Long customerId) throws Exception {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() ->new RecordNotFoundException("Customer id "+ customerId + " is not present. "));
		return populate.populateCustomerDetail(customer);
	}	

}
