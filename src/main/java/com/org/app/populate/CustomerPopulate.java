package com.org.app.populate;

import org.springframework.stereotype.Component;

import com.org.app.entity.Customer;
import com.org.app.viewModel.CustomerDetail;

@Component
public class CustomerPopulate {

	public Customer populateCustomer(CustomerDetail customerDetail) {
		Customer customer = new Customer();
		customer.setAddress(customerDetail.getAddress());
		customer.setCustomerID(customerDetail.getCustomerID());
		customer.setDateOfBirth(customerDetail.getDateOfBirth());
		customer.setEmailAddress(customerDetail.getEmailAddress());
		customer.setName(customerDetail.getName());
		customer.setNationality(customerDetail.getNationality());
		return customer;
	}
	
	public CustomerDetail populateCustomerDetail(Customer customer) {
		CustomerDetail customerDetail = new CustomerDetail();
		customerDetail.setCustomerID(customer.getCustomerID());
		customerDetail.setAddress(customer.getAddress());
		customerDetail.setDateOfBirth(customer.getDateOfBirth());
		customerDetail.setEmailAddress(customer.getEmailAddress());
		customerDetail.setName(customer.getName());
		customerDetail.setNationality(customer.getNationality());
		return customerDetail;
	}
}
