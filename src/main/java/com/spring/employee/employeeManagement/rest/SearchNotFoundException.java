package com.spring.employee.employeeManagement.rest;

public class SearchNotFoundException extends RuntimeException {
	public SearchNotFoundException() {
	}

	public SearchNotFoundException(String message) {
		super(message);
	}

	public SearchNotFoundException(Throwable cause) {
		super(cause);
	}

	public SearchNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SearchNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
