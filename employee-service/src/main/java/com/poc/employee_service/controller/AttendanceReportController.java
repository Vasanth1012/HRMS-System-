package com.poc.employee_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.employee_service.dto.AttendanceDTO;
import com.poc.employee_service.model.Attendance;
import com.poc.employee_service.service.AttendanceReportService;


@RestController
@RequestMapping("/employees/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceReportController {

    @Autowired
    private AttendanceReportService attendanceReportService;

    @GetMapping("/{employeeId}")
    public List<AttendanceDTO> getMonthlyAttendance(@PathVariable Long employeeId,
                                                    @RequestParam int month,
                                                    @RequestParam int year) {
        return attendanceReportService.getMonthlyAttendence(employeeId, month, year).stream()
                                     .map(this::convertEntityToDto)
                                     .collect(Collectors.toList());
    }

    // Conversion method
    private AttendanceDTO convertEntityToDto(Attendance attendance) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.setId(attendance.getId());
        dto.setEmployeeId(attendance.getEmployee().getEmpId());
        dto.setDate(attendance.getDate());
        dto.setClockInTime(attendance.getClockInTime());
        dto.setClockOutTime(attendance.getClockOutTime());
        dto.setAbsent(attendance.isAbsent());
        dto.setOvertimeHours(attendance.getOvertimeHours());
        return dto;
    }
}

/*
 * @CrossOrigin(origins = "http://localhost:3000")
 * 
 * @RestController
 * 
 * @RequestMapping("/employees/reports") public class AttendenceReportController
 * {
 * 
 * @Autowired private AttendanceReportService attendanceReportService;
 * 
 * @GetMapping("/{employeeId}") public List<Attendance>
 * getMonthlyAttendance(@PathVariable Long employeeId,
 * 
 * @RequestParam int month,
 * 
 * @RequestParam int year) { return
 * attendanceReportService.getMonthlyAttendence(employeeId, month, year); } }
 */

