package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This is the model class containing name,projectName and isValid private instance variables.
 * It contains all the getter - setter ,constructors,hashcode,equals method and overrides toString method.
 * @author Rupesh Lal
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AuthenticationResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}
