package com.recruitment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recruitment.entity.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting,Long>{
	
    List<JobPosting> findByTitleContaining(String title);
    
}
