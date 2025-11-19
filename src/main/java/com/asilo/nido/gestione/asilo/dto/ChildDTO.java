package com.asilo.nido.gestione.asilo.dto;

import java.time.LocalDate;

public class ChildDTO {

    private Long id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String classe;
    private String email;
    private String telefono;
    private Long teacherId; // riferimento al teacher

    public ChildDTO() {
    }

    public ChildDTO(Long id, String nome, String cognome, LocalDate dataNascita, String classe, String email, String telefono, Long teacherId) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.classe = classe;
        this.email = email;
        this.telefono = telefono;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
