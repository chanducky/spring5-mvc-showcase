package com.cky.demo.exception;

/**
 * @author chandrakumar
 *
 */
public class BadRequestExcption extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BadRequestExcption() {
		super();
	}

	public BadRequestExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BadRequestExcption(String message, Throwable cause) {
		super(message, cause);
	}

	public BadRequestExcption(String message) {
		super(message);
	}

	public BadRequestExcption(Throwable cause) {
		super(cause);
	}
	
	

}
