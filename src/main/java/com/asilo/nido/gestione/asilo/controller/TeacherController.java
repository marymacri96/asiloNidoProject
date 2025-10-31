package com.asilo.nido.gestione.asilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asilo.nido.gestione.asilo.entity.Teacher;
import com.asilo.nido.gestione.asilo.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	@Autowired
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = teacherService.saveTeacher(teacher);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        try {
            Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
            return ResponseEntity.ok(updatedTeacher);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH BY EMAIL
    @GetMapping("/email")
    public ResponseEntity<Teacher> getTeacherByEmail(@RequestParam String email) {
        return teacherService.getTeacherByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // SEARCH BY NOME
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Teacher>> getTeachersByNome(@PathVariable String nome) {
        return ResponseEntity.ok(teacherService.getTeachersByNome(nome));
    }

    // SEARCH BY COGNOME
    @GetMapping("/cognome/{cognome}")
    public ResponseEntity<List<Teacher>> getTeachersByCognome(@PathVariable String cognome) {
        return ResponseEntity.ok(teacherService.getTeachersByCognome(cognome));
    }

    // SEARCH BY CLASSE
    @GetMapping("/classe/{classe}")
    public ResponseEntity<List<Teacher>> getTeachersByClasse(@PathVariable String classe) {
        return ResponseEntity.ok(teacherService.getTeachersByClasse(classe));
    }

    // SEARCH BY NOME PARZIALE
    @GetMapping("/search/nome")
    public ResponseEntity<List<Teacher>> getTeachersByNomePartial(@RequestParam String nome) {
        return ResponseEntity.ok(teacherService.getTeachersByNomePartial(nome));
    }

    // SEARCH BY COGNOME PARZIALE
    @GetMapping("/search/cognome")
    public ResponseEntity<List<Teacher>> getTeachersByCognomePartial(@RequestParam String cognome) {
        return ResponseEntity.ok(teacherService.getTeachersByCognomePartial(cognome));
    }
}