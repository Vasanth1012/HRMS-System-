package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.entity.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long>{
	
	List<ApplicantRepository> findByJobPostingId(Long jobPostingId);

	List<Applicant> findByStatus(String status);
	
}
