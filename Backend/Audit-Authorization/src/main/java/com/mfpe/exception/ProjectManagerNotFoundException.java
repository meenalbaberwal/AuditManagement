package com.mfpe.exception;

/**
 * 
 * This is exception handler class which handles exceptions related to project manager model class.
 * @author Rupesh Lal
 *
 */
public class ProjectManagerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**
	 *
	 * @param message is passed on to super class.
	 */
	public ProjectManagerNotFoundException(String message) {
		super(message);
	}
	
}
