package com.spring.rest.exception;

/**
 * 
 * @author Rishikesh Shukla
 *
 */
public class CreateObjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8216759473227967267L;

	public CreateObjectException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
