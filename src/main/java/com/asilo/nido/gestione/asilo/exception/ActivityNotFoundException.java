package com.asilo.nido.gestione.asilo.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(Long id) {
        super("Activity non trovata con id: " + id);
    }
}
