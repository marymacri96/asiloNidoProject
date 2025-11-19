package com.asilo.nido.gestione.asilo.repository;

import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByChild(Child child);

    List<Note> findByTeacher(Teacher teacher);
}
