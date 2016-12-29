package com.spring.rest.exception;

/**
 * customized exception for object not found in DB
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5248669276743087559L;

	/**
	 * @param message
	 * @param throwable
	 */
	public ObjectNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
