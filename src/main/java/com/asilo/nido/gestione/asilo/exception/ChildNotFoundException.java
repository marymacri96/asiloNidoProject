package com.asilo.nido.gestione.asilo.exception;

public class ChildNotFoundException extends RuntimeException {
    public ChildNotFoundException(Long id) {
        super("Child non trovato con id: " + id);
    }
}
