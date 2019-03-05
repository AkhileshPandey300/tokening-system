package com.pramati.bank.tokening.system.services;

import java.util.List;

import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.model.Tokens;

/**
 * @author akhileshp
 *
 */
public interface TokensService {

	public Tokens getToken(String phone, long serviceId) throws CustomerNotFoundException;

	public List<Tokens> getTokensByCounter(long counterId);

	public Tokens updateToken(Tokens token, long adminId ,long tokenId) throws RuntimeException;

}
