package com.colegio.microservicio_colegio.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceId) {
        super(String.format(com.colegio.microservicio_colegio.constants.ErrorMessages.RESOURCE_NOT_FOUND, resourceId));
    }
}
