package com.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.entity.OnBoarding;

@Repository
public interface OnBoardingRepository extends JpaRepository<OnBoarding,Long>{
	
    OnBoarding findByApplicantId(Long applicantId);
  
}