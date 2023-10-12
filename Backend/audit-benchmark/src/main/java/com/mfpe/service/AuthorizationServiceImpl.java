package com.mfpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.feign.AuthorizationFeign;
import com.mfpe.model.AuthenticationResponse;
/**
  *service used to get Authenticationresponce
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService{

	@Autowired
	private AuthorizationFeign authClient;
	
	@Override
	public boolean validateJwt(String jwt) {
		AuthenticationResponse authenticationResponse = authClient.validate(jwt).getBody();
		return authenticationResponse.isValid();
	}
	
}
