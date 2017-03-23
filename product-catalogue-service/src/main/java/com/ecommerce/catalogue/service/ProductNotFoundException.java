package com.ecommerce.catalogue.service;

public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1328454195402666463L;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}
}
