package com.asilo.nido.gestione.asilo.service;

import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import com.asilo.nido.gestione.asilo.exception.NoteNotFoundException;
import com.asilo.nido.gestione.asilo.repository.NoteRepository;
import com.asilo.nido.gestione.asilo.repository.ChildRepository;
import com.asilo.nido.gestione.asilo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ChildRepository childRepository;
    private final TeacherRepository teacherRepository;

    public NoteService(NoteRepository noteRepository, ChildRepository childRepository, TeacherRepository teacherRepository) {
        this.noteRepository = noteRepository;
        this.childRepository = childRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public List<Note> getNotesByChild(Long childId) {
        Child child = childRepository.findById(childId)
                .orElseThrow(() -> new RuntimeException("Child non trovato con id: " + childId));
        return noteRepository.findByChild(child);
    }

    public List<Note> getNotesByTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher non trovato con id: " + teacherId));
        return noteRepository.findByTeacher(teacher);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note noteDetails) {
        Note note = getNoteById(id);

        note.setChild(noteDetails.getChild());
        note.setTeacher(noteDetails.getTeacher());
        note.setTesto(noteDetails.getTesto()); // presumo ci sia un campo testo

        return noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        Note note = getNoteById(id);
        noteRepository.delete(note);
    }
}
