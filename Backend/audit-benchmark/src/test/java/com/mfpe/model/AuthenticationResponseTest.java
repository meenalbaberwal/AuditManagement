package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AuthenticationResponseTest {
    @Test
    void testConstructor() {
        AuthenticationResponse actualAuthenticationResponse = new AuthenticationResponse("Name", "Project Name", true);
        actualAuthenticationResponse.setName("Name");
        actualAuthenticationResponse.setProjectName("Project Name");
        actualAuthenticationResponse.setValid(true);
        assertEquals("Name", actualAuthenticationResponse.getName());
        assertEquals("Project Name", actualAuthenticationResponse.getProjectName());
        assertTrue(actualAuthenticationResponse.isValid());
        assertEquals("AuthenticationResponse(name=Name, projectName=Project Name, isValid=true)",
                actualAuthenticationResponse.toString());
    }
}

