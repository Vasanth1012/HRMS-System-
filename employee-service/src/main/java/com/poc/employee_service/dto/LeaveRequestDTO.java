package com.poc.employee_service.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class LeaveRequestDTO {
    private Long id;
    private Long employeeId; // Referencing Employee ID instead of the full object
    private LocalDate leaveDate;
    private String leaveType;
    private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(LocalDate leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
    
}