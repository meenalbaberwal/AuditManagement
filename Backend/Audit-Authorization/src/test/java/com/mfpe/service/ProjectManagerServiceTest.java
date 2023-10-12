package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.model.ProjectManager;
import com.mfpe.repository.ProjectManagerRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProjectManagerService.class})
@ExtendWith(SpringExtension.class)
public class ProjectManagerServiceTest {
    @MockBean
    private ProjectManagerRepo projectManagerRepo;

    @Autowired
    private ProjectManagerService projectManagerService;

    @Test
    public void testGetProjectManagerByUserName() throws ProjectManagerNotFoundException {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("iloveyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");
        when(this.projectManagerRepo.getProjectManagerByUserName(anyString())).thenReturn(projectManager);
        assertSame(projectManager, this.projectManagerService.getProjectManagerByUserName("janedoe"));
        verify(this.projectManagerRepo).getProjectManagerByUserName(anyString());
    }
}

