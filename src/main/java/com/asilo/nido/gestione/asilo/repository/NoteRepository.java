package com.asilo.nido.gestione.asilo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asilo.nido.gestione.asilo.entity.Note;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    //List<Note> findByChildIdChild(Long idChild);

    //List<Note> findByTeacherIdTeacher(Long idTeacher);

    //List<Note> findByChildIdChildAndDataBetween(Long idChild, LocalDate startDate, LocalDate endDate);
}