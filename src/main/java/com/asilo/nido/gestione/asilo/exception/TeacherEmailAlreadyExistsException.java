package com.asilo.nido.gestione.asilo.exception;

public class TeacherEmailAlreadyExistsException extends RuntimeException {
    public TeacherEmailAlreadyExistsException(String email) {
        super("Email già registrata: " + email);
    }
}
