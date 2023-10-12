package com.mfpe.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * This is the model class containing username and password private instance variables.
 * It contains all the getter - setter ,constructors,hashcode,equals method and overrides tostring method.
 * @author Rupesh Lal
 *
 */
@Component
@Data
public class AuthenticationRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
