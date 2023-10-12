package com.mfpe.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.feign.AuditBenchmarkFeign;
import com.mfpe.model.AuditBenchmark;
import com.mfpe.model.AuditDetail;
import com.mfpe.model.AuditRequest;
import com.mfpe.model.AuditResponse;
import com.mfpe.service.AuditResponseService;
import com.mfpe.service.AuthorizationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuditSeverityController.class})
@ExtendWith(SpringExtension.class)
public class AuditSeverityControllerTest {
    @MockBean
    private AuditBenchmarkFeign auditBenchmarkFeign;

    @MockBean
    private AuditResponseService auditResponseService;

    @Autowired
    private AuditSeverityController auditSeverityController;

    @MockBean
    private AuthorizationService authorizationService;

    @Test
    public void testAuditSeverity() throws Exception {
        when(this.authorizationService.validateJwt(anyString())).thenReturn(true);

        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setAuditId(123);
        auditResponse.setProjectName("Project Name");
        auditResponse.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setAuditId(123);
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(this.auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(this.auditResponseService.getAuditResponse((java.util.List<AuditBenchmark>) any(), anyString(),
                (java.util.List<com.mfpe.model.AuditQuestion>) any())).thenReturn(auditResponse);
        when(this.auditBenchmarkFeign.getAuditBenchmark(anyString())).thenReturn(new ArrayList<AuditBenchmark>());

        AuditRequest auditRequest = new AuditRequest();
        auditRequest.setAuditDetail(new AuditDetail());
        auditRequest.setProjectName("Project Name");
        auditRequest.setManagerName("Manager Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.auditSeverityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":123,\"managerName\":\"Manager Name\",\"projectName\":\"Project Name\",\"creationDateTime\":-19800000"
                                        + ",\"projectExecutionStatus\":\"Project Execution Status\",\"remedialActionDuration\":\"Remedial Action"
                                        + " Duration\"}"));
    }

    @Test
    public void testAuditSeverity2() throws Exception {
        when(this.authorizationService.validateJwt(anyString())).thenReturn(false);

        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setAuditId(123);
        auditResponse.setProjectName("Project Name");
        auditResponse.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setAuditId(123);
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(this.auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(this.auditResponseService.getAuditResponse((java.util.List<AuditBenchmark>) any(), anyString(),
                (java.util.List<com.mfpe.model.AuditQuestion>) any())).thenReturn(auditResponse);
        when(this.auditBenchmarkFeign.getAuditBenchmark(anyString())).thenReturn(new ArrayList<AuditBenchmark>());

        AuditRequest auditRequest = new AuditRequest();
        auditRequest.setAuditDetail(new AuditDetail());
        auditRequest.setProjectName("Project Name");
        auditRequest.setManagerName("Manager Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.auditSeverityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":0,\"managerName\":null,\"projectName\":null,\"creationDateTime\":null,\"projectExecutionStatus\""
                                        + ":null,\"remedialActionDuration\":null}"));
    }

    @Test
    public void testAuditSeverity3() throws Exception {
        when(this.authorizationService.validateJwt(anyString())).thenReturn(true);

        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setProjectExecutionStatus("Project Execution Status");
        auditResponse.setAuditId(123);
        auditResponse.setProjectName("Project Name");
        auditResponse.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse.setCreationDateTime(Date.from(atStartOfDayResult.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse.setRemedialActionDuration("Remedial Action Duration");

        AuditResponse auditResponse1 = new AuditResponse();
        auditResponse1.setProjectExecutionStatus("Project Execution Status");
        auditResponse1.setAuditId(123);
        auditResponse1.setProjectName("Project Name");
        auditResponse1.setManagerName("Manager Name");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        auditResponse1.setCreationDateTime(Date.from(atStartOfDayResult1.atZone(ZoneId.systemDefault()).toInstant()));
        auditResponse1.setRemedialActionDuration("Remedial Action Duration");
        when(this.auditResponseService.saveAuditResponse((AuditResponse) any(), (AuditRequest) any()))
                .thenReturn(auditResponse1);
        when(this.auditResponseService.getAuditResponse((java.util.List<AuditBenchmark>) any(), anyString(),
                (java.util.List<com.mfpe.model.AuditQuestion>) any())).thenReturn(auditResponse);
        when(this.auditBenchmarkFeign.getAuditBenchmark(anyString())).thenReturn(new ArrayList<AuditBenchmark>());

        AuditRequest auditRequest = new AuditRequest();
        auditRequest.setAuditDetail(new AuditDetail());
        auditRequest.setProjectName("Project Name");
        auditRequest.setManagerName("Manager Name");
        String content = (new ObjectMapper()).writeValueAsString(auditRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/severity/ProjectExecutionStatus")
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.auditSeverityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isForbidden())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"auditId\":0,\"managerName\":null,\"projectName\":null,\"creationDateTime\":null,\"projectExecutionStatus\""
                                        + ":null,\"remedialActionDuration\":null}"));
    }

    @Test
    public void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/severity/health-check");
        MockMvcBuilders.standaloneSetup(this.auditSeverityController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Severity Microservice is Active"));
    }

    @Test
    public void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/severity/health-check");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.auditSeverityController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Severity Microservice is Active"));
    }
}

