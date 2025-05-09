package com.poc.employee_service.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.employee_service.model.Employee;
import com.poc.employee_service.repository.EmployeeRepository;
import com.poc.employee_service.model.Attendance;
import com.poc.employee_service.repository.AttendanceRepository;



@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Attendance> getAllAttendanceRecords() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> getAttendanceByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployee_EmpId(employeeId);
    }

    public Attendance recordAttendance(Long employeeId, LocalDate date, LocalTime clockIn, LocalTime clockOut, boolean absent) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Attendance attendance = new Attendance();
        attendance.setEmployee(employee);
        attendance.setDate(date);
        attendance.setClockInTime(clockIn);
        attendance.setClockOutTime(clockOut);
        attendance.setAbsent(absent);

        long workHours = ChronoUnit.HOURS.between(clockIn, clockOut);
        attendance.setOvertimeHours(Math.max(workHours - 8, 0));

        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long attendanceId, LocalTime clockIn, LocalTime clockOut, boolean absent) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));

        attendance.setClockInTime(clockIn);
        attendance.setClockOutTime(clockOut);
        attendance.setAbsent(absent);

        long workHours = ChronoUnit.HOURS.between(clockIn, clockOut);
        attendance.setOvertimeHours(Math.max(workHours - 8, 0));

        return attendanceRepository.save(attendance);
    }
}

//@Service
//public class AttendanceService {
//
//    private final AttendanceRepository attendanceRepository;
//    private final EmployeeRepository employeeRepository;
//
//    @Autowired
//    public AttendanceService(AttendanceRepository attendanceRepository, EmployeeRepository employeeRepository) {
//        this.attendanceRepository = attendanceRepository;
//        this.employeeRepository = employeeRepository;
//    }
//
//    // ✅ Fetch all attendance records
//    public List<Attendance> getAllAttendanceRecords() {
//        return attendanceRepository.findAll();
//    }
//
//    // ✅ Fetch attendance records for a specific employee
//    public List<Attendance> getAttendanceByEmployee(Long employeeId) {
//        return attendanceRepository.findByEmployee_EmpId(employeeId);
//    }
//
//    // ✅ Record new attendance
//    public Attendance recordAttendance(Long employeeId, LocalDate date, LocalTime clockIn, LocalTime clockOut, boolean absent) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        if (clockIn == null || clockOut == null) {
//            throw new IllegalArgumentException("Clock-in and clock-out times are required.");
//        }
//
//        Attendance attendance = new Attendance();
//        attendance.setEmployee(employee);
//        attendance.setDate(date);
//        attendance.setClockInTime(clockIn);
//        attendance.setClockOutTime(clockOut);
//        attendance.setAbsent(absent);
//
//        // ✅ Calculate overtime hours correctly
//        long workHours = ChronoUnit.HOURS.between(clockIn, clockOut);
//        attendance.setOvertimeHours(Math.max(workHours - 8, 0));
//
//        return attendanceRepository.save(attendance);
//    }
//
//    // ✅ Update attendance record
//    public Attendance updateAttendance(Long attendanceId, LocalTime clockIn, LocalTime clockOut, boolean absent) {
//        Attendance attendance = attendanceRepository.findById(attendanceId)
//                .orElseThrow(() -> new RuntimeException("Attendance record not found"));
//
//        if (clockIn == null || clockOut == null) {
//            throw new IllegalArgumentException("Clock-in and clock-out times are required.");
//        }
//
//        attendance.setClockInTime(clockIn);
//        attendance.setClockOutTime(clockOut);
//        attendance.setAbsent(absent);
//
//        // ✅ Update overtime hours based on new work duration
//        long workHours = ChronoUnit.HOURS.between(clockIn, clockOut);
//        attendance.setOvertimeHours(Math.max(workHours - 8, 0));
//
//        return attendanceRepository.save(attendance);
//    }
//}