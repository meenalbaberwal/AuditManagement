package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerDetails.class})
@ExtendWith(SpringExtension.class)
public class ProjectManagerDetailsTest {
    @Autowired
    private ProjectManagerDetails projectManagerDetails;

    @Test
    public void testConstructor() {
        ProjectManagerDetails actualProjectManagerDetails = new ProjectManagerDetails();
        assertNull(actualProjectManagerDetails.getName());
        assertNull(actualProjectManagerDetails.getPassword());
        assertNull(actualProjectManagerDetails.getProjectName());
        assertNull(actualProjectManagerDetails.getUsername());
        assertTrue(actualProjectManagerDetails.isAccountNonExpired());
        assertTrue(actualProjectManagerDetails.isAccountNonLocked());
        assertTrue(actualProjectManagerDetails.isCredentialsNonExpired());
        assertTrue(actualProjectManagerDetails.isEnabled());
    }

    @Test
    public void testGetAuthorities() {
        assertTrue(this.projectManagerDetails.getAuthorities().isEmpty());
    }
}

