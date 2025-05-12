package com.hrms.user_service.constants;

public class ValidationConstants {

    // User Validation
    public static final String NAME_REQUIRED = "Please provide your name.";
    public static final String EMAIL_REQUIRED = "Please provide your email.";
    public static final String INVALID_EMAIL = "Invalid email format.";
    public static final String INVALID_PHONE = "Invalid phone number. It should be exactly 10 digits.";
    
    // Role Validation
    public static final String ROLE_REQUIRED = "Role is required.";
    public static final String INVALID_ROLE = "Invalid role. Accepted values: EMPLOYEE, ADMIN, HR_MANAGER.";
    
    // Status Validation
    public static final String STATUS_REQUIRED = "Status cannot be empty.";
    public static final String INVALID_STATUS = "Invalid status. Accepted values: ACTIVE, INACTIVE, TERMINATED.";
    
    // Department Validation
    public static final String DEPARTMENT_REQUIRED = "Department is required.";
    
    // Job Title Validation
    public static final String JOB_TITLE_REQUIRED = "Job title cannot be blank.";
    
    // Profile Image Validation
    public static final String INVALID_PROFILE_IMAGE_PATH = "Invalid profile image path.";
    
    // General Validation Errors
    public static final String FIELD_REQUIRED = "This field is required.";
    public static final String INVALID_INPUT = "Invalid input provided.";
    public static final String PASSWORD_REQUIRED = "Password Required";
}
