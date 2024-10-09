package com.fontys.crowdfund.exception;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists() {

        super("EMAIL_IS_ALREADY_REGISTERED");
    }
}
