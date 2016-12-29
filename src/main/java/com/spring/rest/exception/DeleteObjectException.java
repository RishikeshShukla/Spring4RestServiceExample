package com.spring.rest.exception;

/**
 * @author Rishikesh Shukla
 *
 */
public class DeleteObjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 489617014161798829L;

	public DeleteObjectException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
