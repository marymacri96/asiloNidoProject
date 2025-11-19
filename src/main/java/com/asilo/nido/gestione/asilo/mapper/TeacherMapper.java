package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.TeacherDTO;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    // DTO -> Entity
    public Teacher toEntity(TeacherDTO dto) {
        if (dto == null) return null;

        Teacher teacher = new Teacher();
        teacher.setNome(dto.getNome());
        teacher.setCognome(dto.getCognome());
        teacher.setEmail(dto.getEmail());
        teacher.setPassword(dto.getPassword()); // eventualmente criptare
        teacher.setClasse(dto.getClasse());
        teacher.setTelefono(dto.getTelefono());

        return teacher;
    }

    // Entity -> DTO
    public TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null) return null;

        TeacherDTO dto = new TeacherDTO();
        dto.setNome(teacher.getNome());
        dto.setCognome(teacher.getCognome());
        dto.setEmail(teacher.getEmail());
        dto.setPassword(teacher.getPassword());
        dto.setClasse(teacher.getClasse());
        dto.setTelefono(teacher.getTelefono());

        return dto;
    }
}
