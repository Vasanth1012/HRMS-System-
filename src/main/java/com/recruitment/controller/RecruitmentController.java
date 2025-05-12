package com.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.JobPosting;
import com.recruitment.entity.OnBoarding;
import com.recruitment.service.RecruitmentServiceImplementation;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/recruitment")
public class RecruitmentController {
	
	@Autowired
    private RecruitmentServiceImplementation recruitmentService;

    @PostMapping("/job-posting")
    public ResponseEntity<JobPosting> createJobPosting(@RequestBody JobPosting jobPosting) {
        return ResponseEntity.ok(recruitmentService.createJobPosting(jobPosting));
    }

    @PostMapping("/apply/{jobPostingId}")
    public ResponseEntity<Applicant> applyForJob(@PathVariable Long jobPostingId,
            @RequestBody Applicant applicant) {
        return ResponseEntity.ok(recruitmentService.applyForJob(jobPostingId, applicant));
    }

    @PostMapping("/onboarding/{applicantId}")
    public ResponseEntity<OnBoarding> startOnboarding(@PathVariable Long applicantId,
            @RequestBody OnBoarding onboarding) {
        return ResponseEntity.ok(recruitmentService.startOnboarding(applicantId, onboarding));
    }
    
    @GetMapping("/getJobPosting")
    public ResponseEntity<?> getAllJobs(){
    	return ResponseEntity.ok(recruitmentService.findAllJobs());
    }
}
