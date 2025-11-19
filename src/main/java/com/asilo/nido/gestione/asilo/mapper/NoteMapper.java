package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.NoteDTO;
import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Teacher;

public class NoteMapper {

    public static NoteDTO toDTO(Note note) {
        Long childId = note.getChild() != null ? note.getChild().getId() : null;
        Long teacherId = note.getTeacher() != null ? note.getTeacher().getId() : null;

        return new NoteDTO(
                note.getId(),
                note.getTesto(),
                childId,
                teacherId
        );
    }

    public static Note toEntity(NoteDTO dto) {
        Note note = new Note();
        note.setId(dto.getId());
        note.setTesto(dto.getTesto());

        if (dto.getChildId() != null) {
            Child child = new Child();
            child.setId(dto.getChildId());
            note.setChild(child);
        } else {
            note.setChild(null);
        }

        if (dto.getTeacherId() != null) {
            Teacher teacher = new Teacher();
            teacher.setId(dto.getTeacherId());
            note.setTeacher(teacher);
        } else {
            note.setTeacher(null);
        }

        return note;
    }
}
