package com.spring.rest.exception;

public class ErrorMessage {
	private int status;
	private int errorCode;
	private String errorMessage;

	public ErrorMessage() {

	}

	public ErrorMessage(int status, int errorCode, String errorMessage) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", errorCode=" + errorCode
				+ ", errorMessage=" + errorMessage + "]";
	}

}
