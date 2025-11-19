package com.asilo.nido.gestione.asilo.exception;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Nota non trovata con id: " + id);
    }
}
