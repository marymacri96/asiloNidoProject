package com.asilo.nido.gestione.asilo.dto;

public class LoginResponse {

    private String token;
    private String email;
    private String nome;
    private String cognome;
    private String role;

    public LoginResponse(String token, String email, String nome, String cognome, String role) {
        this.token = token;
        this.email = email;
        this.nome = nome;
        this.cognome = cognome;
        this.role = role;
    }

    // Getter
    public String getToken() { return token; }
    public String getEmail() { return email; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public String getRole() { return role; }
}
