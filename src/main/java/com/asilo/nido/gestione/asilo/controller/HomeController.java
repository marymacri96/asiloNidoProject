package com.asilo.nido.gestione.asilo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Home Controller Funziona!"; // Test semplice, niente HTML
    }
}