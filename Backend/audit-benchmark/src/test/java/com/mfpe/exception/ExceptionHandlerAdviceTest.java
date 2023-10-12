package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ExceptionHandlerAdviceTest {
    @Test
    void testException() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<?> actualExceptionResult = exceptionHandlerAdvice.exception(new Exception("foo"));
        assertEquals("<200 OK OK,[],[]>", actualExceptionResult.toString());
        assertTrue(actualExceptionResult.hasBody());
        assertEquals(HttpStatus.OK, actualExceptionResult.getStatusCode());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
    }
}

