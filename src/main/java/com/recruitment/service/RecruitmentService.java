package com.recruitment.service;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.JobPosting;
import com.recruitment.entity.OnBoarding;

public interface RecruitmentService {
	
    JobPosting createJobPosting(JobPosting jobPosting);

    Applicant applyForJob(Long jobPostingId, Applicant applicant);

    OnBoarding startOnboarding(Long applicantId, OnBoarding onboarding);
    
}
