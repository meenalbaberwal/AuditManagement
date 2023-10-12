package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.model.ProjectManager;
import com.mfpe.model.ProjectManagerDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerService.class, ProjectManagerDetailsService.class})
@ExtendWith(SpringExtension.class)
public class ProjectManagerDetailsServiceTest {
    @Autowired
    private ProjectManagerDetailsService projectManagerDetailsService;

    @MockBean
    private ProjectManagerService projectManagerService;

    @Test
    public void testLoadUserByUsername() throws ProjectManagerNotFoundException, UsernameNotFoundException {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("iloveyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");
        when(this.projectManagerService.getProjectManagerByUserName(anyString())).thenReturn(projectManager);
        ProjectManagerDetails actualLoadUserByUsernameResult = this.projectManagerDetailsService
                .loadUserByUsername("janedoe");
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("Project Name", actualLoadUserByUsernameResult.getProjectName());
        assertEquals("Name", actualLoadUserByUsernameResult.getName());
        verify(this.projectManagerService, times(2)).getProjectManagerByUserName(anyString());
    }
}

