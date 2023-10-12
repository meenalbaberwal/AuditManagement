package com.mfpe.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/**
 * This is exception handler class which handles exceptions related to Jwt validations.
 * @author Shifa Mirza
 *
 */
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger("Benchmark-Exception-Handler-Advice");
	List<String> dummyList = new ArrayList<>();
	
	
	/**
	 * Here it handles if any exception occurs during validation...
	 * we send a Invalid response to the Angular app if exception occurs.
	 * @param e is an object of Exception Class
	 * @return HTTP response with status OK and dummyList
	 */
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(this.dummyList, HttpStatus.OK);
	}
}
