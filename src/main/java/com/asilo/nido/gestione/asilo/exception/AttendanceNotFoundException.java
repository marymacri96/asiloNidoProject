package com.asilo.nido.gestione.asilo.exception;

public class AttendanceNotFoundException extends RuntimeException {
    public AttendanceNotFoundException(Long id) {
        super("Attendance non trovata con id: " + id);
    }
}
