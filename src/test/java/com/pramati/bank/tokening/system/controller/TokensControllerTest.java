/**
 * 
 */
package com.pramati.bank.tokening.system.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramati.bank.tokening.system.model.Tokens;
import com.pramati.bank.tokening.system.services.TokensService;

/**
 * @author pramati
 *
 */
@WebMvcTest(controllers = TokensController.class)
@RunWith(SpringRunner.class)
class TokensControllerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TokensService tokensService;

	@Autowired
	ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.controller.TokensController#getToken(java.lang.String, int)}.
	 */
	@Test
	void testGetToken() throws JsonProcessingException, Exception {
		this.mockMvc.perform(post("/tokens/8693896061/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		verify(this.tokensService, times(1)).getToken("8693896061", 1);
		verifyNoMoreInteractions(this.tokensService);
	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.controller.TokensController#getTokensOfCounter(int)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetCounterTokens() throws Exception {
		this.mockMvc.perform(get("/counters/1/tokens").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		verify(this.tokensService, times(1)).getTokensByCounter(any(Long.class));
		verifyNoMoreInteractions(this.tokensService);

		/*
		 * this.mockMvc.perform(get("/tokens/1").contentType(MediaType.APPLICATION_JSON)
		 * ).andExpect(status().isOk()) .andExpect(content().json("['AA1']"));
		 * verify(this.tokensService, times(1)).getTokensByCounter(any(Integer.class));
		 * verifyNoMoreInteractions(this.tokensService);
		 */

	}

	/**
	 * Test method for
	 * {@link com.pramati.bank.tokening.system.controller.TokensController#updateToken(com.pramati.bank.tokening.system.model.Tokens, int)}.
	 * 
	 * @throws Exception
	 * @throws JsonProcessingException
	 */
	@Test
	void testUpdateToken() throws JsonProcessingException, Exception {

		this.mockMvc
				.perform(put("/counters/tokens/{id}/{tokenId}", 1, 1)
						.content(this.objectMapper.writeValueAsBytes(Tokens.builder().id(1).comment("").counterId(1)
								.customerId(1).status("OPEN").tokenNo("AA1").build()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		verify(this.tokensService, times(1)).updateToken(any(Tokens.class), any(Long.class), any(Long.class));
		verifyNoMoreInteractions(this.tokensService);

	}

}
