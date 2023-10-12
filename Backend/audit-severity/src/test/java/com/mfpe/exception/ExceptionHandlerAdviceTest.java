package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandlerAdviceTest {
    @Test
    public void testException() {
        ExceptionHandlerAdvice exceptionHandlerAdvice = new ExceptionHandlerAdvice();
        ResponseEntity<?> actualExceptionResult = exceptionHandlerAdvice.exception(new Exception("foo"));
        assertEquals("<200 OK OK,AuditResponse(auditId=0, managerName=null, projectName=null, creationDateTime=null,"
                + " projectExecutionStatus=null, remedialActionDuration=null),[]>", actualExceptionResult.toString());
        assertTrue(actualExceptionResult.hasBody());
        assertTrue(actualExceptionResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualExceptionResult.getStatusCode());
    }
}

