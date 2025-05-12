package com.hrms.user_service.dto;

import com.hrms.user_service.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotNull(message = "Role is required")
    private Role role;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Status is required")
    private String status;

    @NotBlank(message = "Job title is required")
    private String jobTitle;

    @NotBlank(message = "Password is required")
    private String password;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }




    public String getPhone() {
        return phone;
    }




    public void setPhone(String phone) {
        this.phone = phone;
    }




    public Role getRole() {
        return role;
    }




    public void setRole(Role role) {
        this.role = role;
    }




    public String getDepartment() {
        return department;
    }




    public void setDepartment(String department) {
        this.department = department;
    }




    public String getStatus() {
        return status;
    }




    public void setStatus(String status) {
        this.status = status;
    }




    public String getJobTitle() {
        return jobTitle;
    }




    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }




    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }




    public String getProfileImg() {
        return profileImg;
    }




    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }




    private String profileImg; // Optional field

}