package com.mfpe.filter;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.mfpe.exception.ProjectManagerNotFoundException;
import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {JwtRequestFilter.class, ProjectManagerDetailsService.class, JwtService.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
public class JwtRequestFilterTest {
    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private ProjectManagerDetailsService projectManagerDetailsService;

    @Test
    public void testDoFilterInternal() throws ProjectManagerNotFoundException, IOException, ServletException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        Response response = new Response();
        FilterChain filterChain = mock(FilterChain.class);
        doNothing().when(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
        this.jwtRequestFilter.doFilterInternal(request, response, filterChain);
        verify(filterChain).doFilter((javax.servlet.ServletRequest) any(), (javax.servlet.ServletResponse) any());
    }
}

