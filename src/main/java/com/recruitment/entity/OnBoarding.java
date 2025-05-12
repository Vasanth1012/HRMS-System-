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
public class OnBoarding {
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public LocalDate getOnboardingDate() {
		return onboardingDate;
	}

	public void setOnboardingDate(LocalDate onboardingDate) {
		this.onboardingDate = onboardingDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="OnBoarding_Id")
    private Long id;
    
    @Column(name="Applicant_Id",nullable=false)
    private Long applicantId; // Reference to Applicant
    
    @Column(name="Document_Status")
    private String documentStatus; // "Documents Submitted", "Pending"
    
    @Column(name="Training_Status")
    private String trainingStatus; // "Training Scheduled", "In Progress", "Completed"
    
    @Column(name="OnBoarding_Date")
    private LocalDate onboardingDate;
    
}
