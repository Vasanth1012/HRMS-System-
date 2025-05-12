package com.hrms.user_service.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.hrms.user_service.constants.ValidationConstants;
import com.hrms.user_service.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`user_table`")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = ValidationConstants.NAME_REQUIRED)
    private String name;

    @Email(message = ValidationConstants.INVALID_EMAIL)
    @NotBlank(message = ValidationConstants.EMAIL_REQUIRED)
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = ValidationConstants.INVALID_PHONE)
    @Column(unique = true)
    private String phone;

    @NotNull(message = ValidationConstants.ROLE_REQUIRED)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @NotBlank(message = ValidationConstants.DEPARTMENT_REQUIRED)
    private String department;

    @NotBlank(message = ValidationConstants.STATUS_REQUIRED)
    private String status;

    @NotBlank(message = ValidationConstants.JOB_TITLE_REQUIRED)
    private String jobTitle;

    @Column(nullable = true) //optional
    private String profileImg;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @NotBlank(message = ValidationConstants.PASSWORD_REQUIRED)
    private String password;


}