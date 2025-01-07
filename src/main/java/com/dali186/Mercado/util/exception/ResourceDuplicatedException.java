package com.dali186.Mercado.util.exception;

public class ResourceDuplicatedException extends RuntimeException {
	
	private final int errorCode;
	
	public <T>ResourceDuplicatedException(String msg, int errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}
