/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.pramati.bank.tokening.system.model.Customer;
import com.pramati.bank.tokening.system.repository.CustomerRepository;
import com.pramati.bank.tokening.system.utils.CustomerType;

/**
 * @author pramati
 *
 */
class CustomerServiceImplTest {
	
	@InjectMocks
	CustomerServiceImpl customerServiceImpl; 

	@Mock
	CustomerRepository  customerRepository;
	
	Customer customer;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		customer = new Customer();
		customer.setId(1);
		customer.setName("Ajay");
		customer.setMobile("8693896061");
		customer.setAddress("BanjarHills");
		customer.setCustomerType(CustomerType.PREMIUM);
	}

	/**
	 * Test method for {@link com.pramati.bank.tokening.system.services.CustomerServiceImpl#addCustomer(com.pramati.bank.tokening.system.model.Customer)}.
	 */
	@Test
	void testAddCustomer() {
		when(customerRepository.save(customer)).thenReturn(customer);
		Customer resultCustomer = customerServiceImpl.addCustomer(customer);
		assertNotNull(resultCustomer);
		assertEquals(customer.getId(), resultCustomer.getId());
		assertEquals(customer.getMobile(), resultCustomer.getMobile());
	}

}
