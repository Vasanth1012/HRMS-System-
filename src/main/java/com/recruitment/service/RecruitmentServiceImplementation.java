package com.recruitment.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.JobPosting;
import com.recruitment.entity.OnBoarding;
import com.recruitment.repository.ApplicantRepository;
import com.recruitment.repository.JobPostingRepository;
import com.recruitment.repository.OnBoardingRepository;

@Service

public class RecruitmentServiceImplementation implements RecruitmentService {
	
	@Autowired
	private JobPostingRepository jobPostingRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private OnBoardingRepository onboardingRepository;

	@Override
	public JobPosting createJobPosting(JobPosting jobPosting) {
		return jobPostingRepository.save(jobPosting);
	}

	@Override
	public Applicant applyForJob(Long jobPostingId, Applicant applicant) {
		return applicantRepository.save(applicant);
	}

	@Override
	public OnBoarding startOnboarding(Long applicantId, OnBoarding onboarding) {
		OnBoarding obj = new OnBoarding();
		obj.setApplicantId(applicantId);
		obj.setOnboardingDate(onboarding.getOnboardingDate());
		return onboardingRepository.save(obj);
	}
	
	public List<JobPosting> findAllJobs(){
		return jobPostingRepository.findAll();
	}
}
