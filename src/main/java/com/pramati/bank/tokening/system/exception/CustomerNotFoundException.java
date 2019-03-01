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
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8780952712438748552L;

	public CustomerNotFoundException(String messageException) {
		super(messageException);
	}
}
