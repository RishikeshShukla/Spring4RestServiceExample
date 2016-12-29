package com.spring.rest.exception;

/**
 * @author Rishikesh Shukla
 *
 */
public class UpdateObjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1110904973656932147L;

	public UpdateObjectException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
