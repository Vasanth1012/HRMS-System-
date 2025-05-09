package com.poc.employee_service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee_service.dto.EmployeeInfoDTO;
import com.poc.employee_service.model.Employee;
import com.poc.employee_service.repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	/*
	 * public Employee getEmployeeById(Long empId) { return
	 * employeeRepository.findById(empId).orElse(null); }
	 */
    
    public EmployeeInfoDTO getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElse(null);
        if (employee == null) {
            return null; // Handle null response properly
        }
        return new EmployeeInfoDTO(
            employee.getEmpId(),
            employee.getName(),
            employee.getEmail(),
            employee.getDepartment(),
            employee.getJobTitle()
        );
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long empId, Employee employee) {
        employee.setEmpId(empId);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
}

/*
 * @Service public class EmployeeService {
 * 
 * @Autowired private EmployeeRepository employeeRepository;
 * 
 * public List<Employee> getAllEmployees() { return
 * employeeRepository.findAll(); }
 * 
 * public Employee getEmployeeById(Long empId) { return
 * employeeRepository.findById(empId).orElse(null); }
 * 
 * public Employee addEmployee(Employee employee) { return
 * employeeRepository.save(employee); }
 * 
 * public Employee updateEmployee(Long empId, Employee employee) {
 * employee.setEmpId(empId); return employeeRepository.save(employee); }
 * 
 * public void deleteEmployee(Long empId) {
 * employeeRepository.deleteById(empId); } }
 */