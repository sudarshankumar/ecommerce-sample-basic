package com.ecommerce.catalogue.service;

public class DuplicateProductException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315246412632284850L;

	public DuplicateProductException() {
		super();
	}

	public DuplicateProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateProductException(String message) {
		super(message);
	}

	public DuplicateProductException(Throwable cause) {
		super(cause);
	}
}
