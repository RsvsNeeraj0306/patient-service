package com.pm.patient_service.exception;

public class EmailAlredyExistException extends RuntimeException {

    public EmailAlredyExistException(String message) {
        super(message);
    }

}
