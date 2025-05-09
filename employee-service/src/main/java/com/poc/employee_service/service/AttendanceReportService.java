package com.poc.employee_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee_service.model.Attendance;
import com.poc.employee_service.repository.AttendanceRepository;

@Service
public class AttendanceReportService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getMonthlyAttendence(Long employeeId, int month, int year) {
        return attendanceRepository.findAll().stream()
                .filter(attendance -> attendance.getEmployee().getEmpId() == employeeId &&
                        attendance.getDate().getMonthValue() == month &&
                        attendance.getDate().getYear() == year)
                .collect(Collectors.toList());
    }
}

/*
 * @Service public class AttendanceReportService {
 * 
 * @Autowired private AttendanceRepository attendanceRepository;
 * 
 * public List<Attendance> getMonthlyAttendence(Long employeeId, int month, int
 * year) { return attendanceRepository.findAll().stream() .filter(attendence ->
 * attendence.getEmployee().getEmpId()==(employeeId) &&
 * attendence.getDate().getMonthValue() == month &&
 * attendence.getDate().getYear() == year) .collect(Collectors.toList()); } }
 */

