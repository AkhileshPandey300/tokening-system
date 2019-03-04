package com.pramati.bank.tokening.system.exception;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4011908198594151323L;

	public UserNotFoundException() {
		super("User Not Found");
	}

}
