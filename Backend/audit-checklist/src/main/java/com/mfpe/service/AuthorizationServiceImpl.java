package com.mfpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.feign.AuthorizationFeign;
import com.mfpe.model.AuthenticationResponse;

@Service
/**
 * This is a Authorization Service Implementation class which implements Authorisation Service class
 * ValidateJwt metho validates the JWT token and returns if it is valid or not
 * @author Shifa Mirza
 *
 */
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	private AuthorizationFeign authClient;
	
	@Override
	public boolean validateJwt(String jwt) {
		AuthenticationResponse authenticationResponse = authClient.validate(jwt).getBody();
		return authenticationResponse.isValid();
	}
	
	
}
