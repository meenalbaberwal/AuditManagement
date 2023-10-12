package com.mfpe.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * here it handles if any exception occurs during validation...
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger("Benchmark-Exception-Handler-Advice");
	
	
	/**
	 *  we send a Invalid response to the Angular app if exception occurs
	 * @param e exception
	 * @return responseEntity
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		logger.error(e.getMessage());
		List<String> dummyList = new ArrayList<>();
		return new ResponseEntity<>(dummyList, HttpStatus.OK);
	}
}
