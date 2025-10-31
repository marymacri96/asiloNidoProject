package com.asilo.nido.gestione.asilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.service.NoteService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

	@Autowired
    private NoteService noteService;

    // CREATE
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedNote = noteService.saveNote(note);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note) {
        try {
            Note updatedNote = noteService.updateNote(id, note);
            return ResponseEntity.ok(updatedNote);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH BY CHILD
    /*@GetMapping("/child/{idChild}")
    public ResponseEntity<List<Note>> getNotesByChild(@PathVariable Long idChild) {
        return ResponseEntity.ok(noteService.getNotesByChildId(idChild));
    }

    // SEARCH BY TEACHER
    @GetMapping("/teacher/{idTeacher}")
    public ResponseEntity<List<Note>> getNotesByTeacher(@PathVariable Long idTeacher) {
        return ResponseEntity.ok(noteService.getNotesByTeacherId(idTeacher));
    }

    // SEARCH BY CHILD AND DATE RANGE
    @GetMapping("/child/{idChild}/daterange")
    public ResponseEntity<List<Note>> getNotesByChildAndDateRange(
            @PathVariable Long idChild,
            @RequestParam("start") String startDateStr,
            @RequestParam("end") String endDateStr
    ) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);
        return ResponseEntity.ok(noteService.getNotesByChildIdAndDateRange(idChild, startDate, endDate));
    }//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'noteController': Unsatisfied dependency expressed through field 'noteService': Error creating bean with name 'noteService': Unsatisfied dependency expressed through field 'noteRepository': Error creating bean with name 'noteRepository' defined in com.asilo.nido.gestione.asilo.repository.NoteRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Could not create query for public abstract java.util.List com.asilo.nido.gestione.asilo.repository.NoteRepository.findByTeacherIdTeacher(java.lang.Long); Reason: Failed to create query for method public abstract java.util.List com.asilo.nido.gestione.asilo.repository.NoteRepository.findByTeacherIdTeacher(java.lang.Long); No property 'teacher' found for type 'Long'; Traversed path: Note.teacher.id
*/
}