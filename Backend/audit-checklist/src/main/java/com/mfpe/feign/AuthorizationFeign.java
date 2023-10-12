package com.mfpe.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.mfpe.model.AuthenticationResponse;

@FeignClient(name="Authorization-Ms", url = "${ms.auth}")
/**
 * This is a feign iterface which has a single method validate which is used to validate the JWT Token
 * @author 2102072
 *
 */
public interface AuthorizationFeign{

	@PostMapping("/validate")
	public ResponseEntity<AuthenticationResponse> validate(@RequestHeader("Authorization") String jwt);

}
