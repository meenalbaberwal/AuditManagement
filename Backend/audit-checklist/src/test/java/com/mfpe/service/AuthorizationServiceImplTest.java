package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.feign.AuthorizationFeign;
import com.mfpe.model.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthorizationServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class AuthorizationServiceImplTest {
    @MockBean
    private AuthorizationFeign authorizationFeign;

    @Autowired
    private AuthorizationServiceImpl authorizationServiceImpl;

    @Test
    public void testValidateJwt() {
        when(this.authorizationFeign.validate(anyString())).thenReturn(new ResponseEntity<AuthenticationResponse>(
                new AuthenticationResponse("Name", "Project Name", true), HttpStatus.CONTINUE));
        assertTrue(this.authorizationServiceImpl.validateJwt("Jwt"));
        verify(this.authorizationFeign).validate(anyString());
    }
}

