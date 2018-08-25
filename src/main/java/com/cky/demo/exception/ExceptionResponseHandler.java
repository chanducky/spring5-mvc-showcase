package com.cky.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author chandrakumar
 *
 */
@ControllerAdvice
public class ExceptionResponseHandler {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> notFounExceptionHandler(NotFoundException e) {
		
		CustomErrorResponse cer = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		e.printStackTrace();
		return new ResponseEntity<CustomErrorResponse>(cer, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestExcption.class)
	public ResponseEntity<?> badRequestExceptionHandler(BadRequestExcption e) {
		
		CustomErrorResponse cer = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		e.printStackTrace();
		return new ResponseEntity<CustomErrorResponse>(cer, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> genericExceptionHandler(Exception e) {
		
		CustomErrorResponse cer = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.name(),System.currentTimeMillis());
		e.printStackTrace();
		return new ResponseEntity<CustomErrorResponse>(cer, HttpStatus.BAD_REQUEST);
	}
}
