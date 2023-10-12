package com.mfpe.controller;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.model.AuthenticationRequest;
import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AuthController.class})
@ExtendWith(SpringExtension.class)
public class AuthControllerTest {

    @Autowired
    private AuthController authController;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private ProjectManagerDetailsService projectManagerDetailsService;

    @Test
    public void testGenerateJwt() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setPassword("isawyou");
        authenticationRequest.setUsername("Jack");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGenerateJwt2() throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setPassword("isawyou");
        authenticationRequest.setUsername("Jack");
        String content = (new ObjectMapper()).writeValueAsString(authenticationRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/authenticate", "Uri Vars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testHealthCheck() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/auth/health-check");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit-Authorization MS Running Fine!!"));
    }

    @Test
    public void testHealthCheck2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/auth/health-check");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Audit-Authorization MS Running Fine!!"));
    }

    @Test
    public void testValidateJwt() throws Exception {
        when(this.projectManagerDetailsService.loadUserByUsername(anyString())).thenReturn(new ProjectManagerDetails());
        when(this.jwtService.extractUsername(anyString())).thenReturn("foo");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/validate")
                .header("Authorization", "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Invalid\",\"projectName\":\"Invalid\",\"valid\":false}"));
    }

    @Test
    public void testValidateJwt2() throws Exception {
        when(this.projectManagerDetailsService.loadUserByUsername(anyString())).thenReturn(new ProjectManagerDetails());
        when(this.jwtService.extractUsername(anyString())).thenReturn("foo");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/auth/validate")
                .header("Authorization", "https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.authController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"name\":\"Invalid\",\"projectName\":\"Invalid\",\"valid\":false}"));
    }
}

