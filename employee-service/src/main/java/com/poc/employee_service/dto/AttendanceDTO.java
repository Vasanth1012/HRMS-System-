package com.poc.employee_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AttendanceDTO {
    private Long id;
    private Long employeeId; // Only storing ID instead of the entire Employee object
    private LocalDate date;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    private boolean absent;
    private double overtimeHours;
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getClockInTime() {
		return clockInTime;
	}
	public void setClockInTime(LocalTime clockInTime) {
		this.clockInTime = clockInTime;
	}
	public LocalTime getClockOutTime() {
		return clockOutTime;
	}
	public void setClockOutTime(LocalTime clockOutTime) {
		this.clockOutTime = clockOutTime;
	}
	public boolean isAbsent() {
		return absent;
	}
	public void setAbsent(boolean absent) {
		this.absent = absent;
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
    
    
}