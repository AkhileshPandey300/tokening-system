/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.repository.CustomerRepository;
import com.pramati.bank.tokening.system.repository.TokenRepository;

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

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void setTokenRepository(TokenRepository tokenRepository) {
		this.tokenRepository = tokenRepository;
	}

	@Override
	public Tokens getToken(long id) throws CustomerNotFoundException {
		 this.customerRepository.findById(id)
		 .orElseThrow(() -> new CustomerNotFoundException("Customer Not Exsist"));
		 
		return null;
	}

}
