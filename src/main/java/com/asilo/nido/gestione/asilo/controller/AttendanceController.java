package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.AttendanceDTO;
import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.mapper.AttendanceMapper;
import com.asilo.nido.gestione.asilo.service.AttendanceService;
import com.asilo.nido.gestione.asilo.service.ChildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final ChildService childService;

    public AttendanceController(AttendanceService attendanceService, ChildService childService) {
        this.attendanceService = attendanceService;
        this.childService = childService;
    }

    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> getAllAttendances() {
        List<AttendanceDTO> attendances = attendanceService.getAllAttendances()
                .stream()
                .map(AttendanceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendanceDTO> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        return ResponseEntity.ok(AttendanceMapper.toDTO(attendance));
    }

    @GetMapping("/child/{childId}")
    public ResponseEntity<List<AttendanceDTO>> getAttendancesByChild(@PathVariable Long childId) {
        Child child = childService.getChildById(childId);
        List<AttendanceDTO> attendances = attendanceService.getAttendancesByChild(child)
                .stream()
                .map(AttendanceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(attendances);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<AttendanceDTO>> getAttendancesByDate(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<AttendanceDTO> attendances = attendanceService.getAttendancesByDate(localDate)
                .stream()
                .map(AttendanceMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(attendances);
    }

    @PostMapping
    public ResponseEntity<AttendanceDTO> createAttendance(@RequestBody AttendanceDTO dto) {
        Child child = childService.getChildById(dto.getChildId());
        Attendance attendance = AttendanceMapper.toEntity(dto, child);
        Attendance created = attendanceService.createAttendance(attendance);
        return new ResponseEntity<>(AttendanceMapper.toDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendanceDTO> updateAttendance(@PathVariable Long id, @RequestBody AttendanceDTO dto) {
        Child child = childService.getChildById(dto.getChildId());
        Attendance attendanceDetails = AttendanceMapper.toEntity(dto, child);
        Attendance updated = attendanceService.updateAttendance(id, attendanceDetails);
        return ResponseEntity.ok(AttendanceMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
    }
}
