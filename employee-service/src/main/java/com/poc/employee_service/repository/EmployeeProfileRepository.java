package com.poc.employee_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.employee_service.model.EmployeeProfile;

@Repository
public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {
    EmployeeProfile findByEmployee_EmpId(Long empId); // ✅ Correct mapping for empId lookup
}




