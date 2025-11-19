package com.asilo.nido.gestione.asilo.exception;

public class UserAlreadyExistsException extends RuntimeException {
    
    public UserAlreadyExistsException(String username) {
        super("Utente già esistente: " + username);
    }

}
