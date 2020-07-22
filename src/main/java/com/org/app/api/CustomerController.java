package com.org.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.app.service.CustomerService;
import com.org.app.viewModel.CustomerDetail;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@ApiOperation(value="Finds customer detail by providing customer id")
	@RequestMapping("/{id}")
	public ResponseEntity<CustomerDetail> findCustomerByCustomerId(@PathVariable("id") long customerId) throws Exception {
		CustomerDetail customerDetail = customerService.findCustomerByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.FOUND).body(customerDetail);
	}
	
}
