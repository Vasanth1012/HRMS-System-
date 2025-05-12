package com.hrms.user_service.constants;

public class MessageConstants {

    // User Operations
    public static final String USER_NOT_FOUND = "User not found.";
    public static final String USER_CREATED = "User created successfully.";
    public static final String USER_UPDATED = "User updated successfully.";
    public static final String USER_DELETED = "User deleted successfully.";
    

    // Role-Based Messages
    public static final String ROLE_NOT_FOUND = "Role not found.";
    public static final String ROLE_UPDATED = "Role updated successfully.";

    // Status Messages
    public static final String STATUS_UPDATED = "User status updated successfully.";
    public static final String INVALID_STATUS_UPDATE = "Cannot update user status to an invalid value.";

    // Job & Department Messages
    public static final String DEPARTMENT_NOT_FOUND = "Department does not exist.";
    public static final String JOB_TITLE_UPDATED = "Job title updated successfully.";

    // Profile Image Upload
    public static final String PROFILE_IMAGE_UPLOADED = "Profile image uploaded successfully.";
    public static final String PROFILE_IMAGE_NOT_FOUND = "Profile image not found.";
    
    // General Error Messages
    public static final String SERVER_ERROR = "Internal server error.";
    public static final String DATABASE_ERROR = "A database error occurred. Please try again later.";
    public static final String ACTION_FAILED = "An unexpected error occurred. Please try again.";
}
