package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.TeacherRequestDTO;
import com.asilo.nido.gestione.asilo.dto.TeacherResponseDTO;
import com.asilo.nido.gestione.asilo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody TeacherRequestDTO requestDTO) {
        TeacherResponseDTO responseDTO = teacherService.createTeacher(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> getAllTeachers() {
        List<TeacherResponseDTO> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(@PathVariable Long id) {
        TeacherResponseDTO teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }
}
