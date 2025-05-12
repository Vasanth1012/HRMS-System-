package com.hrms.user_service.exceptions;


public class ResourceNotFoundException extends RuntimeException{

    private final String resourceName;
    private final Long resourceId;

    public ResourceNotFoundException(String resourceName, Long resourceId, String message) {
        super(message);
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }

    public String getDetailedMessage() {
        return resourceName + " with ID " + resourceId + " - " + getMessage();
    }

    }
