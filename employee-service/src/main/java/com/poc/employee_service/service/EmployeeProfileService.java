package com.poc.employee_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee_service.model.Employee;
import com.poc.employee_service.model.EmployeeProfile;
import com.poc.employee_service.repository.EmployeeProfileRepository;
import com.poc.employee_service.repository.EmployeeRepository;



@Service
public class EmployeeProfileService {

    @Autowired
    private EmployeeProfileRepository employeeProfileRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeProfile getProfile(Long employeeId) {
        return employeeProfileRepository.findByEmployee_EmpId(employeeId);
    }

    public EmployeeProfile updateProfile(Long employeeId, EmployeeProfile updatedProfile) {
        EmployeeProfile profile = employeeProfileRepository.findByEmployee_EmpId(employeeId);

        if (profile == null) {
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            profile = new EmployeeProfile();
            profile.setEmployee(employee);
        }

        profile.setPhoneNumber(updatedProfile.getPhoneNumber());
        profile.setAddress(updatedProfile.getAddress());
        profile.setEmergencyContact(updatedProfile.getEmergencyContact());
        profile.setBankDetails(updatedProfile.getBankDetails());

        return employeeProfileRepository.save(profile);
    }
}

//@Service
//public class EmployeeProfileService {
//    @Autowired
//    private EmployeeProfileRepository employeeProfileRepository;
//    
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    // Get Employee Profile by Employee ID
//    public EmployeeProfile getProfile(Long employeeId) {
//        return employeeProfileRepository.findByEmployee_EmpId(employeeId);
//    }
//
//    // Update or Create Employee Profile
//    public EmployeeProfile updateProfile(Long employeeId, EmployeeProfile updatedProfile) {
//        EmployeeProfile profile = employeeProfileRepository.findByEmployee_EmpId(employeeId);
//
//        // If profile does not exist, create a new one
//        if (profile == null) {
//            Optional<Employee> employeeOpt = employeeRepository.findByEmpId(employeeId);
//
//            if (employeeOpt.isEmpty()) {
//                throw new RuntimeException("Employee not found for ID: " + employeeId);
//            }
//
//            profile = new EmployeeProfile();
//            profile.setEmployee(employeeOpt.get());
//        }
//
//        // Update profile fields
//        profile.setPhoneNumber(updatedProfile.getPhoneNumber());
//        profile.setAddress(updatedProfile.getAddress());
//        profile.setEmergencyContact(updatedProfile.getEmergencyContact());
//        profile.setBankDetails(updatedProfile.getBankDetails());
//
//        return employeeProfileRepository.save(profile);
//    }
//}