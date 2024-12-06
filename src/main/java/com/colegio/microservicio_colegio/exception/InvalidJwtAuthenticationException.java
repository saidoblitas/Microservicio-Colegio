package com.colegio.microservicio_colegio.exception;

public class InvalidJwtAuthenticationException extends RuntimeException {

    public InvalidJwtAuthenticationException() {
        super(com.colegio.microservicio_colegio.constants.ErrorMessages.INVALID_JWT_TOKEN);
    }

    public InvalidJwtAuthenticationException(String message) {
        super(message);
    }
}
