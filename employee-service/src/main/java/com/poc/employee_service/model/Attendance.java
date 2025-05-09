package com.poc.employee_service.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "empId")
    private Employee employee;

    @Column(nullable = false)
    private LocalDate date;

    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    
    @Column(nullable = false)
    private boolean absent;
    
    private double overtimeHours;

    public Attendance() {
        // Default constructor
    }

    public Attendance(Long id, Employee employee, LocalDate date, LocalTime clockInTime, LocalTime clockOutTime, boolean absent, double overtimeHours) {
        this.id = id;
        this.employee = employee;
        this.date = date;
        this.clockInTime = clockInTime;
        this.clockOutTime = clockOutTime;
        this.absent = absent;
        this.overtimeHours = overtimeHours;
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

	

    // Getters and Setters...
}