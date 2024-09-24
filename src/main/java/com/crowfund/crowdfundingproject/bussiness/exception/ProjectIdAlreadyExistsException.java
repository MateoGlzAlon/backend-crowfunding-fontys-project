package com.crowfund.crowdfundingproject.bussiness.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProjectIdAlreadyExistsException extends ResponseStatusException {
    public ProjectIdAlreadyExistsException(String message) {
        super(HttpStatus.BAD_REQUEST, "PROJECT_ID_ALREADY_EXISTS");
    }
}
