package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.NoteDTO;
import com.asilo.nido.gestione.asilo.entity.Note;
import com.asilo.nido.gestione.asilo.mapper.NoteMapper;
import com.asilo.nido.gestione.asilo.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        List<NoteDTO> notes = noteService.getAllNotes()
                .stream()
                .map(NoteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(NoteMapper.toDTO(note));
    }

    @GetMapping("/child/{childId}")
    public ResponseEntity<List<NoteDTO>> getNotesByChild(@PathVariable Long childId) {
        List<NoteDTO> notes = noteService.getNotesByChild(childId)
                .stream()
                .map(NoteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<NoteDTO>> getNotesByTeacher(@PathVariable Long teacherId) {
        List<NoteDTO> notes = noteService.getNotesByTeacher(teacherId)
                .stream()
                .map(NoteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(notes);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) {
        Note note = NoteMapper.toEntity(noteDTO);
        Note created = noteService.createNote(note);
        return new ResponseEntity<>(NoteMapper.toDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoteDTO> updateNote(@PathVariable Long id, @RequestBody NoteDTO noteDTO) {
        Note noteDetails = NoteMapper.toEntity(noteDTO);
        Note updated = noteService.updateNote(id, noteDetails);
        return ResponseEntity.ok(NoteMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }
}
