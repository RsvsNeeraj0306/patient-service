package com.pm.patient_service.exception;

public class EmailAlredyExistException extends RuntimeException {

    public EmailAlredyExistException(String email) {
        super("Email already exists: " + email);
    }

}
