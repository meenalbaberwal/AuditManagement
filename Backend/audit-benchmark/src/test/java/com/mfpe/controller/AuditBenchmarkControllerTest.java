package com.mfpe.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.mfpe.service.AuditBenchmarkService;
import com.mfpe.service.AuthorizationService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuditBenchmarkController.class})
@ExtendWith(SpringExtension.class)
class AuditBenchmarkControllerTest {
    @Autowired
    private AuditBenchmarkController auditBenchmarkController;

    @MockBean
    private AuditBenchmarkService auditBenchmarkService;

    @MockBean
    private AuthorizationService authorizationService;

    @Test
    void testGetAuditBenchmark() throws Exception {
        when(this.authorizationService.validateJwt((String) any())).thenReturn(true);
        when(this.auditBenchmarkService.getAuditBenchmarkList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/benchmark/AuditBenchmark")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.auditBenchmarkController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAuditBenchmark2() throws Exception {
        when(this.authorizationService.validateJwt((String) any())).thenReturn(false);
        when(this.auditBenchmarkService.getAuditBenchmarkList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/benchmark/AuditBenchmark")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.auditBenchmarkController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetAuditBenchmark3() throws Exception {
        when(this.authorizationService.validateJwt((String) any())).thenReturn(true);
        when(this.auditBenchmarkService.getAuditBenchmarkList()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/benchmark/AuditBenchmark")
                .header("Authorization", "");
        MockMvcBuilders.standaloneSetup(this.auditBenchmarkController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/benchmark/health-check");
        MockMvcBuilders.standaloneSetup(this.auditBenchmarkController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Benchmark Microservice is Active"));
    }

    @Test
    void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/benchmark/health-check");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.auditBenchmarkController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit Benchmark Microservice is Active"));
    }
}

