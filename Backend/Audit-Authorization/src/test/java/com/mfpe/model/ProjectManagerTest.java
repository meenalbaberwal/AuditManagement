package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProjectManagerTest {
    @Test
    public void testCanEqual() {
        assertFalse((new ProjectManager(1, "Name", "janedoe", "isawyou", "Project Name")).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        ProjectManager projectManager = new ProjectManager(1, "Name", "janedoe", "isawyou", "Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertTrue(projectManager.canEqual(projectManager1));
    }

    @Test
    public void testConstructor() {
        ProjectManager actualProjectManager = new ProjectManager();
        actualProjectManager.setId(1);
        actualProjectManager.setName("Name");
        actualProjectManager.setPassword("isawyou");
        actualProjectManager.setProjectName("Project Name");
        actualProjectManager.setUsername("janedoe");
        assertEquals(1, actualProjectManager.getId());
        assertEquals("Name", actualProjectManager.getName());
        assertEquals("isawyou", actualProjectManager.getPassword());
        assertEquals("Project Name", actualProjectManager.getProjectName());
        assertEquals("janedoe", actualProjectManager.getUsername());
        assertEquals("ProjectManager(id=1, name=Name, username=janedoe, password=isawyou, projectName=Project Name)",
                actualProjectManager.toString());
    }

    @Test
    public void testConstructor2() {
        ProjectManager actualProjectManager = new ProjectManager(1, "Name", "janedoe", "isawyou", "Project Name");
        actualProjectManager.setId(1);
        actualProjectManager.setName("Name");
        actualProjectManager.setPassword("isawyou");
        actualProjectManager.setProjectName("Project Name");
        actualProjectManager.setUsername("janedoe");
        assertEquals(1, actualProjectManager.getId());
        assertEquals("Name", actualProjectManager.getName());
        assertEquals("isawyou", actualProjectManager.getPassword());
        assertEquals("Project Name", actualProjectManager.getProjectName());
        assertEquals("janedoe", actualProjectManager.getUsername());
        assertEquals("ProjectManager(id=1, name=Name, username=janedoe, password=isawyou, projectName=Project Name)",
                actualProjectManager.toString());
    }

    @Test
    public void testEquals() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");
        assertFalse(projectManager.equals(null));
    }

    @Test
    public void testEquals10() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName(null);
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals11() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("janedoe");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals12() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals13() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName(null);

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals14() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword(null);
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword(null);
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertTrue(projectManager.equals(projectManager1));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager1.hashCode());
    }

    @Test
    public void testEquals15() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername(null);
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername(null);
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertTrue(projectManager.equals(projectManager1));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager1.hashCode());
    }

    @Test
    public void testEquals16() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName(null);
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName(null);
        projectManager1.setProjectName("Project Name");
        assertTrue(projectManager.equals(projectManager1));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager1.hashCode());
    }

    @Test
    public void testEquals17() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName(null);

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName(null);
        assertTrue(projectManager.equals(projectManager1));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager1.hashCode());
    }

    @Test
    public void testEquals2() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");
        assertFalse(projectManager.equals("Different type to ProjectManager"));
    }

    @Test
    public void testEquals3() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");
        assertTrue(projectManager.equals(projectManager));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager.hashCode());
    }

    @Test
    public void testEquals4() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertTrue(projectManager.equals(projectManager1));
        int expectedHashCodeResult = projectManager.hashCode();
        assertEquals(expectedHashCodeResult, projectManager1.hashCode());
    }

    @Test
    public void testEquals5() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("Name");
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals6() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword(null);
        projectManager.setUsername("janedoe");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals7() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("Name");
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals8() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername(null);
        projectManager.setId(1);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }

    @Test
    public void testEquals9() {
        ProjectManager projectManager = new ProjectManager();
        projectManager.setPassword("isawyou");
        projectManager.setUsername("janedoe");
        projectManager.setId(123);
        projectManager.setName("Name");
        projectManager.setProjectName("Project Name");

        ProjectManager projectManager1 = new ProjectManager();
        projectManager1.setPassword("isawyou");
        projectManager1.setUsername("janedoe");
        projectManager1.setId(1);
        projectManager1.setName("Name");
        projectManager1.setProjectName("Project Name");
        assertFalse(projectManager.equals(projectManager1));
    }
}

