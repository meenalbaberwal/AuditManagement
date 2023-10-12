package com.mfpe.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.model.AuditType;
import com.mfpe.model.Question;
import com.mfpe.service.AuthorizationService;
import com.mfpe.service.QuestionService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuditChecklistController.class})
@ExtendWith(SpringExtension.class)
public class AuditChecklistControllerTest {
    @InjectMocks
    private AuditChecklistController auditChecklistController;

    @MockBean
    private AuthorizationService authorizationService;

    @MockBean
    private QuestionService questionService;

    @Test
    public void testAuditCheckListQuestions3() throws Exception {
        when(this.questionService.getQuestionsByAuditType((AuditType) any())).thenReturn(new ArrayList<Question>());
        when(this.authorizationService.validateJwt(anyString())).thenReturn(true);

        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        String content = (new ObjectMapper()).writeValueAsString(auditType);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/AuditCheckListQuestions")
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
    

    @Test
    void testAuditCheckListQuestions6() throws Exception {
        when(this.questionService.getQuestionsByAuditType((AuditType) any())).thenReturn(new ArrayList<>());
        when(this.authorizationService.validateJwt((String) any())).thenReturn(true);

        AuditType auditType = new AuditType();
        auditType.setAuditType("Audit Type");
        String content = (new ObjectMapper()).writeValueAsString(auditType);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/AuditCheckListQuestions")
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    public void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/health-check");
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }

    @Test
    public void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/checklist/health-check");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }

    @Test
    void testHealthCheck3() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/checklist/health-check");
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }

    @Test
    void testHealthCheck4() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/checklist/health-check");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.auditChecklistController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Checklist Microservice is Active"));
    }
}

