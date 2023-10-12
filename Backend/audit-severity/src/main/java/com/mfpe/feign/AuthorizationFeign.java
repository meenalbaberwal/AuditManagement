package com.mfpe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuthenticationResponse;

/**
 * 
 * This is Feign interface which has a single method validate which is used validate Jwt token
 * by connecting this microservice with Authorization microservice. 
 * @author Rupesh Lal
 *
 */
@FeignClient(name="Authorization-Ms", url = "${ms.auth}")
public interface AuthorizationFeign{

	@PostMapping("/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}
