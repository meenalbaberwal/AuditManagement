package com.mfpe.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditQuestion;
import com.mfpe.model.AuditRequest;
import com.mfpe.model.AuditResponse;
import com.mfpe.repository.AuditResponseRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuditResponseServiceImpl.class, AuditRequest.class})
@ExtendWith(SpringExtension.class)
public class AuditResponseServiceImplTest {
    @Autowired
    private AuditRequest auditRequest;

    @MockBean
    private AuditResponseRepo auditResponseRepo;

    @Autowired
    private AuditResponseServiceImpl auditResponseServiceImpl;

    @Test
    public void testCreateAuditResponse() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCreateAuditResponse2() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(-1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCreateAuditResponse3() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Internal", "Response"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("No action needed", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("GREEN", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCreateAuditResponse4() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "SOX", "Response"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("No action needed", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("GREEN", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCreateAuditResponse5() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "No"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(1,
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCreateAuditResponse6() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Internal", "Response"));
        AuditResponse actualCreateAuditResponseResult = this.auditResponseServiceImpl.createAuditResponse(-1,
                auditQuestionList);
        assertEquals("Action to be taken in 2 weeks", actualCreateAuditResponseResult.getRemedialActionDuration());
        assertEquals("RED", actualCreateAuditResponseResult.getProjectExecutionStatus());
    }

    @Test
    public void testCountNos() {
        assertEquals(0, this.auditResponseServiceImpl.countNos(new ArrayList<AuditQuestion>()));
    }

    @Test
    public void testCountNos2() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        assertEquals(0, this.auditResponseServiceImpl.countNos(auditQuestionList));
    }

    @Test
    public void testCountNos3() {
        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "No"));
        assertEquals(1, this.auditResponseServiceImpl.countNos(auditQuestionList));
    }

    @Test
    public void testGetAuditResponse() {
        ArrayList<AuditBenchmark> benchmarkList = new ArrayList<AuditBenchmark>();

        ArrayList<AuditQuestion> auditQuestionList = new ArrayList<AuditQuestion>();
        auditQuestionList.add(new AuditQuestion(123, "Question", "Audit Type", "Response"));
        AuditResponse actualAuditResponse = this.auditResponseServiceImpl.getAuditResponse(benchmarkList, "Audit Type",
                auditQuestionList);
        assertEquals("Action to be taken in 1 week", actualAuditResponse.getRemedialActionDuration());
        assertEquals("RED", actualAuditResponse.getProjectExecutionStatus());
    }

    @Test
    public void testSaveAuditResponse() {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setAuditId(123);
        auditResponse.setProjectName("Project Name");
        auditResponse.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse.setRemedialActionDuration("Remedial Action Duration");
        when(this.auditResponseRepo.save((AuditResponse) any())).thenReturn(auditResponse);

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setAuditId(123);
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        assertSame(auditResponse, this.auditResponseServiceImpl.saveAuditResponse(auditResponse1, this.auditRequest));
        verify(this.auditResponseRepo).save((AuditResponse) any());
        assertNull(auditResponse1.getProjectName());
        assertNull(auditResponse1.getManagerName());
    }
}

