package com.recruitment.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class JobPosting {
	
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDate postingDate) {
		this.postingDate = postingDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="JobPosting_Id",nullable=false)
    private Long id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="location")
    private String location;
    
    @Column(name="salary")
    private Double salary;
    
    @Column(name="posting_Date")
    private LocalDate postingDate;
    
    @Column(name="closing_Date")
    private LocalDate closingDate;
    
}
