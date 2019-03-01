package com.pramati.bank.tokening.system.services;

import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.model.Tokens;

/**
 * @author akhileshp
 *
 */
public interface TokensService {
	
	public Tokens getToken(long id) throws CustomerNotFoundException;

}
