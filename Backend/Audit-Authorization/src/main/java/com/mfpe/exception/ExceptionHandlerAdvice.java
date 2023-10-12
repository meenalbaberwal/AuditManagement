package com.mfpe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mfpe.model.AuthenticationResponse;

/**
 * 
 * This is exception handler class which handles exceptions related to Jwt validations.
 * @author Rupesh Lal
 *
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	Logger logger = LoggerFactory.getLogger("Auth-Exception-Handler-Advice");
	
	/**
	 * 
	 * Here it handles if any exception occurs during validation...
	 * we send a Invalid response to the Angular app if exception occurs.
	 * @param ex is object of class MethodArgumentNotValidException.
	 * @return Http response with status FORBIDDEN and a message to user.
	 * 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> validationExceptions(MethodArgumentNotValidException ex) {
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        logger.error(error.getDefaultMessage());
	    });
	    return new ResponseEntity<String>("Give Username and Password in proper-format", HttpStatus.FORBIDDEN);
	}
	
	/**
	 * 
	 * This method is used to continue the flow of program even if the user is not a valid user.
	 * @param e which is object of Exception Class
	 * @return Http response with status OK and an object of AuthenticationResponse model class.
	 * 
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
		logger.error(e.getMessage());
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("Invalid", "Invalid", false);
		return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
	}
}
