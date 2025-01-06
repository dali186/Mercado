package com.dali186.Mercado.util.exception;

public class ResourceNotFoundException extends RuntimeException {

	private final int errorCode;
	
	public <T>ResourceNotFoundException(String msg, int errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
