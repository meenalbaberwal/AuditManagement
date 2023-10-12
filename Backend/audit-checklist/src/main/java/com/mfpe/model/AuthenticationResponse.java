package com.mfpe.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
/**
 * This is the model class containing name,projectName and isValid private instance variables.
 * It contains all the getter - setter ,constructors,hashcode,equals method and overrides toString method.
 * @author Shifa Mirza
 *
 */
public class AuthenticationResponse {
	private String name;
	private String projectName;
	private boolean isValid;
}
