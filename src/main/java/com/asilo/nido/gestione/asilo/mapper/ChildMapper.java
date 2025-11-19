package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.ChildDTO;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Teacher;

public class ChildMapper {

    public static ChildDTO toDTO(Child child) {
        Long teacherId = child.getTeacher() != null ? child.getTeacher().getId() : null;
        return new ChildDTO(
                child.getId(),
                child.getNome(),
                child.getCognome(),
                child.getDataNascita(),
                child.getClasse(),
                child.getEmail(),
                child.getTelefono(),
                teacherId
        );
    }

    public static Child toEntity(ChildDTO dto) {
        Child child = new Child();
        child.setId(dto.getId());
        child.setNome(dto.getNome());
        child.setCognome(dto.getCognome());
        child.setDataNascita(dto.getDataNascita());
        child.setClasse(dto.getClasse());
        child.setEmail(dto.getEmail());
        child.setTelefono(dto.getTelefono());

        if (dto.getTeacherId() != null) {
            Teacher teacher = new Teacher();
            teacher.setId(dto.getTeacherId());
            child.setTeacher(teacher);
        } else {
            child.setTeacher(null);
        }

        return child;
    }
}
