package com.mfpe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditRequest.class})
@ExtendWith(SpringExtension.class)
public class AuditRequestTest {
    @InjectMocks
    private AuditRequest auditRequest;

    @Test
    public void testCanEqual() {
        assertFalse(this.auditRequest.canEqual("Other"));
        assertTrue(this.auditRequest.canEqual(this.auditRequest));
    }

    @Test
    public void testConstructor() {
        AuditRequest actualAuditRequest = new AuditRequest();
        AuditDetail auditDetail = new AuditDetail();
        actualAuditRequest.setAuditDetail(auditDetail);
        actualAuditRequest.setManagerName("Manager Name");
        actualAuditRequest.setProjectName("Project Name");
        assertSame(auditDetail, actualAuditRequest.getAuditDetail());
        assertEquals("Manager Name", actualAuditRequest.getManagerName());
        assertEquals("Project Name", actualAuditRequest.getProjectName());
        assertEquals(
                "AuditRequest(projectName=Project Name, managerName=Manager Name, auditDetail=AuditDetail(auditType=null,"
                        + " auditDate=null, auditQuestions=null))",
                actualAuditRequest.toString());
    }

    @Test
    public void testConstructor2() {
        AuditDetail auditDetail = new AuditDetail();
        AuditRequest actualAuditRequest = new AuditRequest("Project Name", "Manager Name", auditDetail);
        AuditDetail auditDetail1 = new AuditDetail();
        actualAuditRequest.setAuditDetail(auditDetail1);
        actualAuditRequest.setManagerName("Manager Name");
        actualAuditRequest.setProjectName("Project Name");
        AuditDetail auditDetail2 = actualAuditRequest.getAuditDetail();
        assertSame(auditDetail1, auditDetail2);
        assertEquals(auditDetail, auditDetail2);
        assertEquals("Manager Name", actualAuditRequest.getManagerName());
        assertEquals("Project Name", actualAuditRequest.getProjectName());
        assertEquals(
                "AuditRequest(projectName=Project Name, managerName=Manager Name, auditDetail=AuditDetail(auditType=null,"
                        + " auditDate=null, auditQuestions=null))",
                actualAuditRequest.toString());
    }

    @Test
    public void testEquals() {
        assertFalse((new AuditRequest()).equals(null));
        assertFalse((new AuditRequest()).equals("Different type to AuditRequest"));
    }

    @Test
    public void testEquals2() {
        AuditRequest auditRequest = new AuditRequest();
        assertTrue(auditRequest.equals(auditRequest));
        int expectedHashCodeResult = auditRequest.hashCode();
        assertEquals(expectedHashCodeResult, auditRequest.hashCode());
    }

    @Test
    public void testEquals3() {
        AuditRequest auditRequest = new AuditRequest();
        AuditRequest auditRequest1 = new AuditRequest();
        assertTrue(auditRequest.equals(auditRequest1));
        int expectedHashCodeResult = auditRequest.hashCode();
        assertEquals(expectedHashCodeResult, auditRequest1.hashCode());
    }

    @Test
    public void testEquals4() {
        AuditRequest auditRequest = new AuditRequest("Project Name", "Manager Name", new AuditDetail());
        assertFalse(auditRequest.equals(new AuditRequest()));
    }

    @Test
    public void testEquals5() {
        AuditRequest auditRequest = new AuditRequest();
        assertFalse(auditRequest.equals(new AuditRequest("Project Name", "Manager Name", new AuditDetail())));
    }

    @Test
    public void testEquals6() {
        AuditRequest auditRequest = new AuditRequest(null, "Manager Name", new AuditDetail());
        assertFalse(auditRequest.equals(new AuditRequest()));
    }
}

