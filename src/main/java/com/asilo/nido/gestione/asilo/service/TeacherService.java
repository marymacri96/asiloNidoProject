package com.asilo.nido.gestione.asilo.service;

import com.asilo.nido.gestione.asilo.dto.TeacherRequestDTO;
import com.asilo.nido.gestione.asilo.dto.TeacherResponseDTO;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import com.asilo.nido.gestione.asilo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponseDTO createTeacher(TeacherRequestDTO requestDTO) {
        Teacher teacher = new Teacher();
        teacher.setNome(requestDTO.getNome());
        teacher.setCognome(requestDTO.getCognome());
        teacher.setEmail(requestDTO.getEmail());
        teacher.setPassword(requestDTO.getPassword()); // da criptare se vuoi
        teacher.setClasse(requestDTO.getClasse());
        teacher.setTelefono(requestDTO.getTelefono());

        teacher = teacherRepository.save(teacher); // salva nel DB e genera ID corretto

        TeacherResponseDTO response = new TeacherResponseDTO();
        response.setId(teacher.getId());
        response.setNome(teacher.getNome());
        response.setCognome(teacher.getCognome());
        response.setEmail(teacher.getEmail());
        response.setClasse(teacher.getClasse());
        response.setTelefono(teacher.getTelefono());

        return response;
    }

    public List<TeacherResponseDTO> getAllTeachers() {
        List<TeacherResponseDTO> list = new ArrayList<>();
        teacherRepository.findAll().forEach(teacher -> {
            TeacherResponseDTO dto = new TeacherResponseDTO();
            dto.setId(teacher.getId());
            dto.setNome(teacher.getNome());
            dto.setCognome(teacher.getCognome());
            dto.setEmail(teacher.getEmail());
            dto.setClasse(teacher.getClasse());
            dto.setTelefono(teacher.getTelefono());
            list.add(dto);
        });
        return list;
    }

    public TeacherResponseDTO getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + id));
        TeacherResponseDTO dto = new TeacherResponseDTO();
        dto.setId(teacher.getId());
        dto.setNome(teacher.getNome());
        dto.setCognome(teacher.getCognome());
        dto.setEmail(teacher.getEmail());
        dto.setClasse(teacher.getClasse());
        dto.setTelefono(teacher.getTelefono());
        return dto;
    }
}
