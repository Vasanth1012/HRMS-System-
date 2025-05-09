package com.poc.employee_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id" ,referencedColumnName = "empId")
    private Employee employee;

    private LocalDate leaveDate;
    private String leaveType; // Example: Sick Leave, Casual Leave, etc.
    private String status; // Pending, Approved, Rejected
    
    public LeaveRequest() {
    	this.id = id;
		this.employee = employee;
		this.leaveDate = leaveDate;
		this.leaveType = leaveType;
		this.status = status;
    }
    
    
	public LeaveRequest(Long id, Employee employee, LocalDate leaveDate, String leaveType, String status) {
		super();
		this.id = id;
		this.employee = employee;
		this.leaveDate = leaveDate;
		this.leaveType = leaveType;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
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


	@Override
	public String toString() {
		return "LeaveRequest [id=" + id + ", employee=" + employee + ", leaveDate=" + leaveDate + ", leaveType="
				+ leaveType + ", status=" + status + "]";
	}
    
    
    
   

}
