package com.poc.employee_service.dto;

import lombok.Data;

@Data
public class EmployeeInfoDTO {
    private Long empId;
    private String name;
    private String email;
    private String department;
    private String jobTitle;
    
    
    
    
    
    
	public EmployeeInfoDTO() {
		super();
	}
	public EmployeeInfoDTO(Long empId, String name, String email, String department, String jobTitle) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.department = department;
		this.jobTitle = jobTitle;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Override
	public String toString() {
		return "EmployeeInfoDTO [empId=" + empId + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", jobTitle=" + jobTitle + "]";
	}
	
    
    
}