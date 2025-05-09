package com.poc.employee_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poc.employee_service.dto.AttendanceDTO;
import com.poc.employee_service.model.Attendance;
import com.poc.employee_service.service.AttendanceService;




@RestController
@RequestMapping("/employees/attendance")
@CrossOrigin(origins = "http://localhost:3000")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<AttendanceDTO> getAllAttendanceRecords() {
        return attendanceService.getAllAttendanceRecords().stream()
                                .map(this::convertEntityToDto)
                                .collect(Collectors.toList());
    }

    @GetMapping("/{employeeId}")
    public List<AttendanceDTO> getAttendanceByEmployee(@PathVariable Long employeeId) {
        return attendanceService.getAttendanceByEmployee(employeeId).stream()
                                .map(this::convertEntityToDto)
                                .collect(Collectors.toList());
    }

    @PostMapping("/{employeeId}")
    public AttendanceDTO recordAttendance(@PathVariable Long employeeId, @RequestBody AttendanceDTO attendanceDTO) {
        Attendance attendance = convertDtoToEntity(attendanceDTO);
        return convertEntityToDto(attendanceService.recordAttendance(
            employeeId, 
            attendance.getDate(), 
            attendance.getClockInTime(), 
            attendance.getClockOutTime(), 
            attendance.isAbsent()
        ));
    }

    @PutMapping("/{attendanceId}")
    public AttendanceDTO updateAttendance(@PathVariable Long attendanceId, @RequestBody AttendanceDTO attendanceDTO) {
        return convertEntityToDto(attendanceService.updateAttendance(
            attendanceId, 
            attendanceDTO.getClockInTime(), 
            attendanceDTO.getClockOutTime(), 
            attendanceDTO.isAbsent()
        ));
    }

    // Conversion methods
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

    private Attendance convertDtoToEntity(AttendanceDTO dto) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setDate(dto.getDate());
        attendance.setClockInTime(dto.getClockInTime());
        attendance.setClockOutTime(dto.getClockOutTime());
        attendance.setAbsent(dto.isAbsent());
        attendance.setOvertimeHours(dto.getOvertimeHours());
        return attendance;
    }
}

//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/employees/attendance")
//public class AttendanceController {
//
//    private final AttendanceService attendanceService;
//
//    @Autowired
//    public AttendanceController(AttendanceService attendanceService) {
//        this.attendanceService = attendanceService;
//    }
//
//    // ✅ Fetch all attendance records
//    @GetMapping
//    public List<Attendance> getAllAttendanceRecords() {
//        return attendanceService.getAllAttendanceRecords();
//    }
//    
//    // ✅ Fetch attendance records for a specific employee
//    @GetMapping("/{employeeId}")
//    public List<Attendance> getAttendanceByEmployee(@PathVariable Long employeeId) {
//        return attendanceService.getAttendanceByEmployee(employeeId);
//    }
//
//    // ✅ Record new attendance for an employee
//    @PostMapping("/{employeeId}")
//    public Attendance recordAttendance(
//            @PathVariable Long employeeId, 
//            @RequestBody Attendance attendanceRequest) {
//        return attendanceService.recordAttendance(
//                employeeId, 
//                attendanceRequest.getDate(), 
//                attendanceRequest.getClockInTime(), 
//                attendanceRequest.getClockOutTime(), 
//                attendanceRequest.isAbsent()
//        );
//    }
//
//    // ✅ Update attendance record for an employee
//    @PutMapping("/{attendanceId}")
//    public Attendance updateAttendance(
//            @PathVariable Long attendanceId,
//            @RequestBody Attendance attendanceRequest) {
//        return attendanceService.updateAttendance(
//                attendanceId, 
//                attendanceRequest.getClockInTime(), 
//                attendanceRequest.getClockOutTime(), 
//                attendanceRequest.isAbsent()
//        );
//    }
//}