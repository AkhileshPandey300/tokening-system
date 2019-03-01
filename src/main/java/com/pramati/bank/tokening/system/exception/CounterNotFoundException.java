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
public class CounterNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4823232614868435482L;

	public CounterNotFoundException(String messageException) {
		super(messageException);
	}
}
