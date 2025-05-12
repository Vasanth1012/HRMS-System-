package com.recruitment.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Applicant {
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Long jobPostingId) {
		this.jobPostingId = jobPostingId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Applicant_Id",nullable=false)
    private Long id;
    
    @Column(name="jobPosting_Id",nullable=false)
    private Long jobPostingId; // Reference to JobPosting
    
    @Column(name="Applicant_Name",nullable=false)
    private String name;
    
    @Column(name="Applicant_Email",nullable=false)
    private String email;
    
    @Column(name="Applicant_Status")
    private String status; // e.g., "Applied", "Interview Scheduled", "Hired"
    
    @Column(name="Application_Date")
    private LocalDate applicationDate;
    
}