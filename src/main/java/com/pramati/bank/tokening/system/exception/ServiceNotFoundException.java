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
public class ServiceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1893784823294501594L;
	
	public ServiceNotFoundException(String messageException) {
		super(messageException);
	}

}
