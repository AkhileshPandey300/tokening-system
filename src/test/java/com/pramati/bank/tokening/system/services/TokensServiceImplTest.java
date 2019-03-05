/**
 * 
 */
package com.pramati.bank.tokening.system.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.repository.AdminRepository;
import com.pramati.bank.tokening.system.repository.CounterRepository;
import com.pramati.bank.tokening.system.repository.CustomerRepository;
import com.pramati.bank.tokening.system.repository.TokenRepository;
import com.pramati.bank.tokening.system.utils.TokenStatus;

/**
 * @author pramati
 *
 */
class TokensServiceImplTest {

	@InjectMocks
	TokensServiceImpl tokensServiceImpl;

	@Mock
	TokenRepository tokenRepository;

	@Spy
	CustomerRepository customerRepository;

	@Mock
	CounterRepository counterRepository;

	@Mock
	AdminRepository adminRepository;

	Tokens token;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		token = new Tokens();
		token.setId(1L);
		token.setTokenNo("AA1");
		token.setCustomerId(1L);
		token.setCounterId(1L);
		token.setStatus(TokenStatus.OPEN.toString());
		token.setComment("");
	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.services.TokensServiceImpl#getToken(java.lang.String, long)}.
	 */
	@Test
	void testGetToken() {
		Tokens resultTokens = this.tokensServiceImpl.getToken("8693896061", 1L);
		assertNotNull(resultTokens);
		assertEquals(token.getId(), resultTokens.getId());
		assertEquals(token.getTokenNo(), resultTokens.getTokenNo());
	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.services.TokensServiceImpl#getTokensByCounter(long)}.
	 */
	@Test
	@Disabled
	void testGetTokensByCounter() {
		List<Tokens> resultTokens = tokensServiceImpl.getTokensByCounter(1L);
		assertNotNull(resultTokens);
		assertEquals(token.getId(), resultTokens.get(0).getId());
		assertEquals(token.getTokenNo(), resultTokens.get(0).getTokenNo());
	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.services.TokensServiceImpl#updateToken(com.pramati.bank.tokening.system.model.Tokens, long)}.
	 */
	@Test
	@Disabled
	void testUpdateToken() {
		when(tokenRepository.save(token)).thenReturn(token);

		Assertions.assertThrows(Exception.class,

				() -> {
					tokensServiceImpl.updateToken(token, 1L, 1L);
				});
		Tokens resultTokens = tokensServiceImpl.updateToken(token, 1L, 1L);

		assertNotNull(resultTokens);
		assertEquals(token.getTokenNo(), resultTokens.getTokenNo());
		assertEquals(token.getStatus(), resultTokens.getStatus());

	}

}
