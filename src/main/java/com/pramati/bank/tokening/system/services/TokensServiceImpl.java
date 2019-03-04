/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.TransactionScoped;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.exception.UserNotFoundException;
import com.pramati.bank.tokening.system.model.Admin;
import com.pramati.bank.tokening.system.model.Counter;
import com.pramati.bank.tokening.system.model.Customer;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.repository.AdminRepository;
import com.pramati.bank.tokening.system.repository.CounterRepository;
import com.pramati.bank.tokening.system.repository.CustomerRepository;
import com.pramati.bank.tokening.system.repository.TokenRepository;
import com.pramati.bank.tokening.system.utils.TokenStatus;
import com.pramati.bank.tokening.system.utils.UserEnum;

/**
 * @author akhileshp
 *
 */
@Service
public class TokensServiceImpl implements TokensService {

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CounterRepository counterRepository;

	@Autowired
	private AdminRepository adminRepository;

	public void setAdminRepository(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	public void setCounterRepository(CounterRepository counterRepository) {
		this.counterRepository = counterRepository;
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void setTokenRepository(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	@Override
	@Transactional(propagation =Propagation.REQUIRED)
	public Tokens getToken(String phone, long serviceId) throws CustomerNotFoundException, CounterNotFoundException {
		Customer customer = this.customerRepository.findByMobile(phone);
		Counter counter = null;
		if (customer != null) {
			counter = this.counterRepository.findByServiceId(serviceId);
			if (counter == null)
				throw new CounterNotFoundException("Counter Not Found");
		} else
			throw new CustomerNotFoundException("Customer Not Found");

		return tokenRepository.save(generateToken(customer, counter));
	}

	@Override
	@Transactional
	public List<Tokens> getTokensByCounter(long counterId) {
		List<Tokens> list = null;
		try (Stream<Tokens> stream = this.tokenRepository.findByCounterId(counterId)) {
			list = stream.collect(Collectors.toList());
		}
		return list;

	}

	@Override
	@Transactional
	public Tokens updateToken(Tokens token, long adminId) {
		Optional<Admin> adminOptional = this.adminRepository.findById(adminId);
		if (!adminOptional.isPresent())
			throw new UserNotFoundException();
		String userRole = adminOptional.get().getRole();
		if (!userRole.equalsIgnoreCase(UserEnum.MANAGER.toString())
				&& !userRole.equalsIgnoreCase(UserEnum.OPERATOR.toString()))
			throw new RuntimeException();

		return this.tokenRepository.save(token);
	}

	public Tokens generateToken(Customer customer, Counter counter) {
		Tokens token = new Tokens();
		token.setComment("");
		token.setCounterId(counter.getId());
		token.setCustomerId(customer.getId());
		token.setStatus(TokenStatus.OPEN.toString());
		token.setTokenNo(tokenNumber());
		return token;

	}

	public String tokenNumber() {
		return RandomStringUtils.randomAlphanumeric(5);

	}

}
