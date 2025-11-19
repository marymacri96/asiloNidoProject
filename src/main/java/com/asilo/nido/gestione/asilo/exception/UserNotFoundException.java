package com.asilo.nido.gestione.asilo.exception;

public class UserNotFoundException extends RuntimeException {
    
    public UserNotFoundException(String username) {
        super("Utente non trovato: " + username);
    }

}
