package com.ecommerce.pricing.service;

public class PriceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9156670499276316167L;

	public PriceNotFoundException() {
		super();
	}

	public PriceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PriceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriceNotFoundException(String message) {
		super(message);
	}

	public PriceNotFoundException(Throwable cause) {
		super(cause);
	}
	
}
