package com.spring.rest.exception;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rest.util.Constants;

/**
 * class to handle exception across the application
 * */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = Logger
			.getLogger(GlobalExceptionHandler.class);

	@Autowired
	ErrorMessage errorMessage;

	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ErrorMessage> handleSQLException(
			SQLException sqlException) {
		errorMessage.setStatus(Constants.FAILED);
		errorMessage.setErrorCode(Constants.SQL_ERROR_CODE);
		errorMessage.setErrorMessage(Constants.REQUEST_FAILED_MESSAGE
				+ sqlException.getMessage());
		logger.error("Request failed due to SQLException : "
				+ sqlException.getCause());
		return new ResponseEntity<ErrorMessage>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DataException.class)
	public ResponseEntity<ErrorMessage> handleSQLException(
			DataException dataException) {
		errorMessage.setStatus(Constants.FAILED);
		errorMessage.setErrorCode(Constants.DATA_ERROR_CODE);
		errorMessage.setErrorMessage(Constants.REQUEST_FAILED_MESSAGE
				+ dataException.getMessage());
		logger.error("Request failed due to DataExeption   : "
				+ dataException.getCause());
		return new ResponseEntity<ErrorMessage>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGenericException(
			Exception exception) {
		errorMessage.setStatus(Constants.FAILED);
		errorMessage.setErrorMessage(Constants.REQUEST_FAILED_MESSAGE
				+ exception.getLocalizedMessage());
		logger.error("Request failed due to Exception : "
				+ exception.getCause());
		logger.error(exception.getCause());
		return new ResponseEntity<ErrorMessage>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ ObjectNotFoundException.class,
			CreateObjectException.class, UpdateObjectException.class,
			DeleteObjectException.class })
	public ResponseEntity<ErrorMessage> handleGenericException(
			ObjectNotFoundException exception) {
		errorMessage.setStatus(Constants.FAILED);
		errorMessage.setErrorMessage(exception.getLocalizedMessage());
		logger.error("Request failed due to Exception : "
				+ exception.getCause());
		return new ResponseEntity<ErrorMessage>(errorMessage,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
