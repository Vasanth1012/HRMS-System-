package com.poc.employee_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_profiles")
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "empId")
    private Employee employee;

    private String phoneNumber;
    private String address;
    private String emergencyContact;
    private String bankDetails;
    
    
    public EmployeeProfile() {
        // Default constructor should be empty
    }


    
    
	public EmployeeProfile(Long id, Employee employee, String phoneNumber, String address, String emergencyContact,
			String bankDetails) {
		super();
		this.id = id;
		this.employee = employee;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.emergencyContact = emergencyContact;
		this.bankDetails = bankDetails;
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


	@Override
	public String toString() {
		return "EmployeeProfile [id=" + id + ", employee=" + employee + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", emergencyContact=" + emergencyContact + ", bankDetails=" + bankDetails + "]";
	}

    
    
}
