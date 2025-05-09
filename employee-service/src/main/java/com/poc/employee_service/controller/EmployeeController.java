package com.poc.employee_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee_service.dto.EmployeeInfoDTO;
import com.poc.employee_service.model.Employee;
import com.poc.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeInfoDTO> getAllEmployees() {
        return employeeService.getAllEmployees().stream()
                              .map(this::convertEntityToDto)
                              .collect(Collectors.toList());
    }

	/*
	 * @GetMapping("/{empId}") public EmployeeInfoDTO getEmployeeById(@PathVariable
	 * Long empId) { return
	 * convertEntityToDto(employeeService.getEmployeeById(empId)); }
	 */
    
    @GetMapping("/{id}")
    public EmployeeInfoDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }


    @PostMapping
    public EmployeeInfoDTO addEmployee(@RequestBody EmployeeInfoDTO employeeInfoDTO) {
        Employee employee = convertDtoToEntity(employeeInfoDTO);
        return convertEntityToDto(employeeService.addEmployee(employee));
    }

    @PutMapping("/{empId}")
    public EmployeeInfoDTO updateEmployee(@PathVariable Long empId, @RequestBody EmployeeInfoDTO employeeInfoDTO) {
        Employee employee = convertDtoToEntity(employeeInfoDTO);
        return convertEntityToDto(employeeService.updateEmployee(empId, employee));
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable Long empId) {
        employeeService.deleteEmployee(empId);
    }

    // Conversion methods
    private EmployeeInfoDTO convertEntityToDto(Employee employee) {
    	EmployeeInfoDTO dto = new EmployeeInfoDTO();
        dto.setEmpId(employee.getEmpId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDepartment(employee.getDepartment());
        dto.setJobTitle(employee.getJobTitle());
        return dto;
    }

    private Employee convertDtoToEntity(EmployeeInfoDTO dto) {
        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setJobTitle(dto.getJobTitle());
        return employee;
    }
}

//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/{empId}")
//    public Employee getEmployeeById(@PathVariable Long empId) {
//        return employeeService.getEmployeeById(empId);
//    }
//
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeService.addEmployee(employee);
//    }
//
//    @PutMapping("/{empId}")
//    public Employee updateEmployee(@PathVariable Long empId, @RequestBody Employee employee) {
//        return employeeService.updateEmployee(empId, employee);
//    }
//
//    @DeleteMapping("/{empId}")
//    public void deleteEmployee(@PathVariable Long empId) {
//        employeeService.deleteEmployee(empId);
//    }
//}


