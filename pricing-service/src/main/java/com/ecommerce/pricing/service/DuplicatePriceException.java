package com.ecommerce.pricing.service;

public class DuplicatePriceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -309934877680501073L;

	public DuplicatePriceException() {
		super();
	}

	public DuplicatePriceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicatePriceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicatePriceException(String message) {
		super(message);
	}

	public DuplicatePriceException(Throwable cause) {
		super(cause);
	}

}
