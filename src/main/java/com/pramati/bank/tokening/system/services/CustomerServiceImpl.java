/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pramati.bank.tokening.system.model.Customer;
import com.pramati.bank.tokening.system.repository.CustomerRepository;

/**
 * @author akhileshp
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	
	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);

	}

}
