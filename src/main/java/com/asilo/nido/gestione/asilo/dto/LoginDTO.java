package com.asilo.nido.gestione.asilo.dto;

public class LoginDTO {
    private String token;
    private String email;
    private String nome;
    private String cognome;
    private String role;

    // Getter e Setter
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
