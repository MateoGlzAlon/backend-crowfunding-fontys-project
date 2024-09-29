package com.fontys.crowdfunding.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidProjectException extends ResponseStatusException {
    public InvalidProjectException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}