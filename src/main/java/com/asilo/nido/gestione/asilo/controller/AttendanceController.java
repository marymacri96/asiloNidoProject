package com.asilo.nido.gestione.asilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.service.AttendanceService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
	@Autowired
    private AttendanceService attendanceService;

    // CREATE
    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        return ResponseEntity.ok(attendanceService.getAllAttendances());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        try {
            Attendance updated = attendanceService.updateAttendance(id, attendance);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendanceById(id);
        return ResponseEntity.noContent().build();
    }

    // GET BY CHILD ID
   /* @GetMapping("/child/{idChild}")
    public ResponseEntity<List<Attendance>> getAttendancesByChild(@PathVariable Long idChild) {
        return ResponseEntity.ok(attendanceService.getAttendancesByChildId(idChild));
    }*/

    // GET BY CHILD ID AND DATE RANGE
    /*@GetMapping("/child/{idChild}/daterange")
    public ResponseEntity<List<Attendance>> getAttendancesByChildAndDateRange(
            @PathVariable Long idChild,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return ResponseEntity.ok(attendanceService.getAttendancesByChildIdAndDateRange(idChild, start, end));
    }*/
}