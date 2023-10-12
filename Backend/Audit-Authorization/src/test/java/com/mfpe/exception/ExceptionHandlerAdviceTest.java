package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mfpe.model.AuthenticationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerAdviceTest {
    @Test
    public void testException() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<Object> actualExceptionResult = exceptionHandlerAdvice.exception(new Exception("foo"));
        assertEquals("<200 OK OK,AuthenticationResponse(name=Invalid, projectName=Invalid, isValid=false),[]>",
                actualExceptionResult.toString());
        assertTrue(actualExceptionResult.hasBody());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualExceptionResult.getStatusCode());
        assertEquals("Invalid", ((AuthenticationResponse) actualExceptionResult.getBody()).getName());
        assertEquals("Invalid", ((AuthenticationResponse) actualExceptionResult.getBody()).getProjectName());
        assertFalse(((AuthenticationResponse) actualExceptionResult.getBody()).isValid());
    }
}

