package com.poc.employee_service.dto;

import lombok.Data;

@Data
public class EmployeeProfileDTO {
    private Long id;
    private Long employeeId; // Only storing ID instead of the full Employee object
    private String phoneNumber;
    private String address;
    private String emergencyContact;
    private String bankDetails;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getBankDetails() {
		return bankDetails;
	}
	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}
    
    
}