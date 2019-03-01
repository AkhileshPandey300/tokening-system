/**
 * 
 */
package com.pramati.bank.tokening.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.services.TokensService;

/**
 * @author pramati
 *
 */
@RestController
@RequestMapping("/tokens")
public class TokensController {

	@Autowired
	private TokensService tokenService;

	public void setTokenService(TokensService tokenService) {
		this.tokenService = tokenService;
	}

	@GetMapping("/{id}")
	public Tokens getToken(@PathVariable(value = "id") long id) {
		Tokens token = this.tokenService.getToken(id);

		return null;

	}

}
