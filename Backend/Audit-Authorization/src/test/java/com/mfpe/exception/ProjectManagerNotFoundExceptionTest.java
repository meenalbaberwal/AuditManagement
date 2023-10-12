package com.mfpe.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ProjectManagerNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        ProjectManagerNotFoundException actualProjectManagerNotFoundException = new ProjectManagerNotFoundException(
                "An error occurred");
        assertNull(actualProjectManagerNotFoundException.getCause());
        assertEquals("com.mfpe.exception.ProjectManagerNotFoundException: An error occurred",
                actualProjectManagerNotFoundException.toString());
        assertEquals(0, actualProjectManagerNotFoundException.getSuppressed().length);
        assertEquals("An error occurred", actualProjectManagerNotFoundException.getMessage());
        assertEquals("An error occurred", actualProjectManagerNotFoundException.getLocalizedMessage());
    }
}

