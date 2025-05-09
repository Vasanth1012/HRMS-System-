package com.poc.employee_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee_service.dto.EmployeeProfileDTO;
import com.poc.employee_service.model.EmployeeProfile;
import com.poc.employee_service.service.EmployeeProfileService;


@RestController
@RequestMapping("/employees/profile")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeProfileController {

    @Autowired
    private EmployeeProfileService employeeProfileService;

    @GetMapping("/{employeeId}")
    public EmployeeProfileDTO getProfile(@PathVariable Long employeeId) {
        return convertEntityToDto(employeeProfileService.getProfile(employeeId));
    }

    @PutMapping("/{employeeId}")
    public EmployeeProfileDTO updateProfile(@PathVariable Long employeeId, @RequestBody EmployeeProfileDTO profileDTO) {
        EmployeeProfile profile = convertDtoToEntity(profileDTO);
        return convertEntityToDto(employeeProfileService.updateProfile(employeeId, profile));
    }

    // Conversion methods
    private EmployeeProfileDTO convertEntityToDto(EmployeeProfile profile) {
        EmployeeProfileDTO dto = new EmployeeProfileDTO();
        dto.setId(profile.getId());
        dto.setEmployeeId(profile.getEmployee().getEmpId());
        dto.setPhoneNumber(profile.getPhoneNumber());
        dto.setAddress(profile.getAddress());
        dto.setEmergencyContact(profile.getEmergencyContact());
        dto.setBankDetails(profile.getBankDetails());
        return dto;
    }

    private EmployeeProfile convertDtoToEntity(EmployeeProfileDTO dto) {
        EmployeeProfile profile = new EmployeeProfile();
        profile.setId(dto.getId());
        profile.setPhoneNumber(dto.getPhoneNumber());
        profile.setAddress(dto.getAddress());
        profile.setEmergencyContact(dto.getEmergencyContact());
        profile.setBankDetails(dto.getBankDetails());
        return profile;
    }
}


//@CrossOrigin(origins = "http://localhost:3000")
//
//@RestController
//@RequestMapping("/employees/profile")
//public class EmployeeProfileController {
//    @Autowired
//    private EmployeeProfileService employeeProfileService;
//
//    @GetMapping("/{employeeId}")
//    public EmployeeProfile getProfile(@PathVariable Long employeeId) {
//        return employeeProfileService.getProfile(employeeId);
//    }
//
//    @PutMapping("/{employeeId}")
//    public EmployeeProfile updateProfile(@PathVariable Long employeeId, @RequestBody EmployeeProfile profile) {
//        System.out.println("Received Profile: " + profile); // Debugging step
//        if (profile == null) {
//            throw new IllegalArgumentException("Request body is missing or invalid.");
//        }
//        return employeeProfileService.updateProfile(employeeId, profile);
//    }
//
//
//}
