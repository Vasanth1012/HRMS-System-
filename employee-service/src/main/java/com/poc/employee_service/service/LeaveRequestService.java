package com.poc.employee_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee_service.model.Employee;
import com.poc.employee_service.model.LeaveRequest;
import com.poc.employee_service.repository.EmployeeRepository;
import com.poc.employee_service.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public LeaveRequest applyLeave(Long employeeId, LocalDate leaveDate, String leaveType) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployee(employee);
        leaveRequest.setLeaveDate(leaveDate);
        leaveRequest.setLeaveType(leaveType);
        leaveRequest.setStatus("Pending");

        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getLeaveRequests(Long employeeId) {
        return leaveRequestRepository.findByEmployee_empId(employeeId);
    }

    public LeaveRequest updateLeaveStatus(Long leaveId, String status) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave request not found"));
        leaveRequest.setStatus(status);
        return leaveRequestRepository.save(leaveRequest);
    }
}

/*
 * @Service public class LeaveRequestService {
 * 
 * @Autowired private LeaveRequestRepository leaveRequestRepository;
 * 
 * @Autowired private EmployeeRepository employeeRepository;
 * 
 * public LeaveRequest applyLeave(Long employeeId, LocalDate leaveDate, String
 * leaveType) { Employee employee = employeeRepository.findById(employeeId)
 * .orElseThrow(() -> new RuntimeException("Employee not found"));
 * 
 * LeaveRequest leaveRequest = new LeaveRequest();
 * leaveRequest.setEmployee(employee); leaveRequest.setLeaveDate(leaveDate);
 * leaveRequest.setLeaveType(leaveType); leaveRequest.setStatus("Pending");
 * 
 * return leaveRequestRepository.save(leaveRequest); }
 * 
 * public List<LeaveRequest> getLeaveRequests(Long employeeId) { return
 * leaveRequestRepository.findByEmployee_empId(employeeId); }
 * 
 * public LeaveRequest updateLeaveStatus(Long leaveId, String status) {
 * LeaveRequest leaveRequest = leaveRequestRepository.findById(leaveId)
 * .orElseThrow(() -> new RuntimeException("Leave request not found"));
 * leaveRequest.setStatus(status); return
 * leaveRequestRepository.save(leaveRequest); }
 * 
 * }
 */