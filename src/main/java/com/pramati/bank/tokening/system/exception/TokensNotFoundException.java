/**
 * 
 */
package com.pramati.bank.tokening.system.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author pramati
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class TokensNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8614887849946706488L;
	
	public TokensNotFoundException(String messageException) {
		super(messageException);
	}

}
