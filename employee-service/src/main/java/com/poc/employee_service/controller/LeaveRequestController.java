package com.poc.employee_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee_service.dto.LeaveRequestDTO;
import com.poc.employee_service.model.LeaveRequest;
import com.poc.employee_service.service.LeaveRequestService;



@RestController
@RequestMapping("/employees/leave")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @PostMapping("/{employeeId}")
    public LeaveRequestDTO applyLeave(@PathVariable Long employeeId, @RequestBody LeaveRequestDTO leaveRequestDTO) {
        LeaveRequest leaveRequest = convertDtoToEntity(leaveRequestDTO);
        return convertEntityToDto(leaveRequestService.applyLeave(
                employeeId, leaveRequest.getLeaveDate(), leaveRequest.getLeaveType()));
    }

    @GetMapping("/my-leaves/{employeeId}")
    public List<LeaveRequestDTO> getMyLeaves(@PathVariable Long employeeId) {
        return leaveRequestService.getLeaveRequests(employeeId).stream()
                                  .map(this::convertEntityToDto)
                                  .collect(Collectors.toList());
    }

    @PutMapping("/{leaveId}")
    public LeaveRequestDTO updateLeaveStatus(@PathVariable Long leaveId, @RequestParam String status) {
        return convertEntityToDto(leaveRequestService.updateLeaveStatus(leaveId, status));
    }

    // Conversion methods
    private LeaveRequestDTO convertEntityToDto(LeaveRequest leaveRequest) {
        LeaveRequestDTO dto = new LeaveRequestDTO();
        dto.setId(leaveRequest.getId());
        dto.setEmployeeId(leaveRequest.getEmployee().getEmpId());
        dto.setLeaveDate(leaveRequest.getLeaveDate());
        dto.setLeaveType(leaveRequest.getLeaveType());
        dto.setStatus(leaveRequest.getStatus());
        return dto;
    }

    private LeaveRequest convertDtoToEntity(LeaveRequestDTO dto) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setId(dto.getId());
        leaveRequest.setLeaveDate(dto.getLeaveDate());
        leaveRequest.setLeaveType(dto.getLeaveType());
        leaveRequest.setStatus(dto.getStatus());
        return leaveRequest;
    }
}
/*
 * @CrossOrigin(origins = "http://localhost:3000")
 * 
 * @RestController
 * 
 * @RequestMapping("/employees/leave") public class LeaveRequestController {
 * 
 * @Autowired private LeaveRequestService leaveRequestService;
 * 
 * @PostMapping("/{employeeId}") public LeaveRequest applyLeave(@PathVariable
 * Long employeeId,
 * 
 * @RequestParam LocalDate leaveDate,
 * 
 * @RequestParam String leaveType) { return
 * leaveRequestService.applyLeave(employeeId, leaveDate, leaveType); }
 * 
 * @GetMapping("/my-leaves/{employeeId}") public List<LeaveRequest>
 * getMyLeaves(@PathVariable Long employeeId) { return
 * leaveRequestService.getLeaveRequests(employeeId); }
 * 
 * 
 * @PutMapping("/{leaveId}") public LeaveRequest updateLeaveStatus(@PathVariable
 * Long leaveId, @RequestParam String status) { return
 * leaveRequestService.updateLeaveStatus(leaveId, status); } }
 * 
 */