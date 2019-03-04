package com.pramati.bank.tokening.system.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.bank.tokening.system.model.Customer;
import com.pramati.bank.tokening.system.services.CustomerService;

@RestController
@RequestMapping("")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);

	}
}
