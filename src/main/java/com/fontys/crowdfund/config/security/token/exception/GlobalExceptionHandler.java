/*package com.fontys.crowdfund.config.security.token.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex, Authentication authentication) {
        if (authentication != null) {
            String roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("No roles");
            System.out.println("Access denied for user with roles: " + roles);
        } else {
            System.out.println("Access denied: No authentication details found.");
        }
        return ResponseEntity.status(403).body("Access denied: " + ex.getMessage());
    }
}
*/