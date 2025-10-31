package com.asilo.nido.gestione.asilo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.repository.NoteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
	@Autowired
    private NoteRepository noteRepository;


    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        return noteRepository.findById(id)
                .map(existingNote -> {
                    existingNote.setTesto(updatedNote.getTesto());
                    existingNote.setData(updatedNote.getData());
                    existingNote.setChild(updatedNote.getChild());
                    existingNote.setTeacher(updatedNote.getTeacher());
                    return noteRepository.save(existingNote);
                }).orElseThrow(() -> new RuntimeException("Nota non trovata con id " + id));
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    /*public List<Note> getNotesByChildId(Long idChild) {
        return noteRepository.findByChildIdChild(idChild);
    }

    public List<Note> getNotesByTeacherId(Long idTeacher) {
        return noteRepository.findByTeacherIdTeacher(idTeacher);
    }

    public List<Note> getNotesByChildIdAndDateRange(Long idChild, LocalDate startDate, LocalDate endDate) {
        return noteRepository.findByChildIdChildAndDataBetween(idChild, startDate, endDate);
    }*/
}