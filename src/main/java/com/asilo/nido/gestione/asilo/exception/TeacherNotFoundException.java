package com.asilo.nido.gestione.asilo.exception;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super("Teacher non trovato con id: " + id);
    }

    public TeacherNotFoundException(String email) {
        super("Teacher non trovato con email: " + email);
    }
}
