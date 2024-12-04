package com.fontys.crowdfund.security.authTest;

import com.fontys.crowdfund.config.security.auth.AuthenticationRequestFilter;
import com.fontys.crowdfund.config.security.token.AccessToken;
import com.fontys.crowdfund.config.security.token.AccessTokenDecoder;
import com.fontys.crowdfund.config.security.token.exception.InvalidAccessTokenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthenticationRequestFilterTest {
/*
    @Mock
    private AccessTokenDecoder accessTokenDecoder;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @Mock
    private AccessToken mockAccessToken; // Mocked AccessToken

    @InjectMocks
    private AuthenticationRequestFilter filter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        SecurityContextHolder.clearContext(); // Clear the SecurityContext before each test
    }

    @Test
    void doFilterInternal_WithValidToken_SetsSecurityContext() throws Exception {
        // Arrange
        String validToken = "Bearer valid.jwt.token";
        when(request.getHeader("Authorization")).thenReturn(validToken);
        when(accessTokenDecoder.decode("valid.jwt.token")).thenReturn(mockAccessToken);

        // Mock the behavior of AccessToken methods
        when(mockAccessToken.getSubject()).thenReturn("user123");
        when(mockAccessToken.getRoles()).thenReturn(Collections.singleton("USER")); // Use Collections.singletonList

        // Act
        filter.doFilterInternal(request, response, filterChain);

        // Assert
        SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNotNull(securityContext.getAuthentication());
        assertEquals("user123", securityContext.getAuthentication().getName());
        assertTrue(securityContext.getAuthentication().getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));

        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternal_WithInvalidToken_SendsUnauthorizedResponse() throws Exception {
        // Arrange
        String invalidToken = "Bearer invalid.jwt.token";
        when(request.getHeader("Authorization")).thenReturn(invalidToken);
        when(accessTokenDecoder.decode("invalid.jwt.token")).thenThrow(new InvalidAccessTokenException("Invalid token"));

        // Act
        filter.doFilterInternal(request, response, filterChain);

        // Assert
        verify(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        verify(response).flushBuffer();
        verify(filterChain, never()).doFilter(any(), any());
    }

    @Test
    void doFilterInternal_WithMissingAuthorizationHeader_CallsNextFilter() throws Exception {
        // Arrange
        when(request.getHeader("Authorization")).thenReturn(null);

        // Act
        filter.doFilterInternal(request, response, filterChain);

        // Assert
        SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNull(securityContext.getAuthentication());
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternal_WithNonBearerAuthorizationHeader_CallsNextFilter() throws Exception {
        // Arrange
        when(request.getHeader("Authorization")).thenReturn("Basic dXNlcjpwYXNz");

        // Act
        filter.doFilterInternal(request, response, filterChain);

        // Assert
        SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNull(securityContext.getAuthentication());
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void setupSpringSecurityContext_SetsAuthenticationInSecurityContext() {
        // Arrange
        when(mockAccessToken.getSubject()).thenReturn("user123");
        when(mockAccessToken.getRoles()).thenReturn(Collections.singleton("USER")); // Use Collections.singletonList

        // Act
        filter.setupSpringSecurityContext(mockAccessToken);

        // Assert
        SecurityContext securityContext = SecurityContextHolder.getContext();
        assertNotNull(securityContext.getAuthentication());
        assertEquals("user123", securityContext.getAuthentication().getName());
        assertTrue(securityContext.getAuthentication().getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));
    }
    */

}
