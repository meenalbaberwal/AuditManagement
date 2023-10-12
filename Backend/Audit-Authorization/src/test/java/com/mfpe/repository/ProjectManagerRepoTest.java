package com.mfpe.repository;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.mfpe.model.ProjectManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProjectManagerRepoTest {
    @Autowired
    private ProjectManagerRepo projectManagerRepo;

    @Test
    public void testGetProjectManagerByUserName() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("iloveyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("iloveyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        this.projectManagerRepo.<ProjectManager>save(projectManager);
        this.projectManagerRepo.<ProjectManager>save(projectManager1);
        assertNull(this.projectManagerRepo.getProjectManagerByUserName("foo"));
    }
}

