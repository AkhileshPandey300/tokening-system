package com.pramati.bank.tokening.system.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.bank.tokening.system.model.Customer;
import com.pramati.bank.tokening.system.services.CustomerService;
import com.pramati.bank.tokening.system.utils.CustomerType;

class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Autowired
	ObjectMapper objectMapper;

	private final String URL = "/customers";

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddCustomer() throws JsonProcessingException, Exception {

		// data and mock's behaviour
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("Sumith");
		customer.setMobile("8693896063");
		customer.setCustomerType(CustomerType.PREMIUM);
		customer.setCreatedAt(null);
		customer.setCreatedBy("");
		customer.setUpdatedAt(null);
		customer.setUpdatedBy("");

		this.mockMvc.perform(post(URL)
				.content(this.objectMapper.writeValueAsBytes(Customer.builder().name("Sachin").mobile("8888888888")
						.address("Mumbai").customerType(CustomerType.REGULAR).build()))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

		verify(this.customerService, times(1)).addCustomer(any(Customer.class));
		verifyNoMoreInteractions(this.customerService);

	}

}
