package com.asilo.nido.gestione.asilo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asilo.nido.gestione.asilo.entity.Teacher;
import com.asilo.nido.gestione.asilo.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

	@Autowired
    private TeacherRepository teacherRepository;
	
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    existingTeacher.setNome(updatedTeacher.getNome());
                    existingTeacher.setCognome(updatedTeacher.getCognome());
                    existingTeacher.setClasse(updatedTeacher.getClasse());
                    existingTeacher.setEmail(updatedTeacher.getEmail());
                    existingTeacher.setTelefono(updatedTeacher.getTelefono());
                    return teacherRepository.save(existingTeacher);
                }).orElseThrow(() -> new RuntimeException("Teacher non trovato con id: " + id));
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    public Optional<Teacher> getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }

    public List<Teacher> getTeachersByNome(String nome) {
        return teacherRepository.findByNome(nome);
    }

    public List<Teacher> getTeachersByCognome(String cognome) {
        return teacherRepository.findByCognome(cognome);
    }

    public List<Teacher> getTeachersByClasse(String classe) {
        return teacherRepository.findByClasse(classe);
    }

    public List<Teacher> getTeachersByNomePartial(String partialNome) {
        return teacherRepository.findByNomeContainingIgnoreCase(partialNome);
    }

    public List<Teacher> getTeachersByCognomePartial(String partialCognome) {
        return teacherRepository.findByCognomeContainingIgnoreCase(partialCognome);
    }
}