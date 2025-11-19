package com.asilo.nido.gestione.asilo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users/profile")
    public String getProfile() {
        return "Accesso consentito! Il JWT Filter ha funzionato.";
    }
}
