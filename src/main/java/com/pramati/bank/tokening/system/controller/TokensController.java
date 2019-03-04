/**
 * 
 */
package com.pramati.bank.tokening.system.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pramati.bank.tokening.system.exception.CounterNotFoundException;
import com.pramati.bank.tokening.system.exception.CustomerNotFoundException;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.services.TokensService;

/**
 * @author pramati
 *
 */
@RestController
@RequestMapping("")
public class TokensController {

	@Autowired
	private TokensService tokenService;

	public void setTokenService(TokensService tokenService) {
		this.tokenService = tokenService;
	}

	@PostMapping("/tokens/{mobile}/{id}")
	public Tokens getToken(@PathVariable(value = "mobile") String mobile, @PathVariable(value = "id") int serviceId)
			throws CustomerNotFoundException, CounterNotFoundException {

		return this.tokenService.getToken(mobile, serviceId);

	}

	@GetMapping("/counters/{id}/tokens")
//	@GetMapping("/tokens/{id}")
	public List<Tokens> getCounterTokens(@PathVariable(value = "id") long counterId) {
		return this.tokenService.getTokensByCounter(counterId);

	}

	@PutMapping("/counters/tokens/{id}")
	public Tokens updateToken(@Valid @RequestBody Tokens token, @PathVariable(value = "id") long adminId) {
		return this.tokenService.updateToken(token, adminId);

	}

}
