package com.fontys.crowdfund.exception;

public class ProjectAlreadyExists extends RuntimeException {
    public ProjectAlreadyExists() {
        super("PROJECT_ID_ALREADY_EXISTS");
    }
}
