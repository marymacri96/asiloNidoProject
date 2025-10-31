package com.asilo.nido.gestione.asilo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
public class Teacher implements Serializable {

    
	private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "TeacherSequence", sequenceName = "TEACHER_ID_TEACHER_SEQ", allocationSize = 1)
   	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TeacherSequence")
    @Column(name = "id_teacher")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "classe", length = 20)
    private String classe;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    // Relazioni
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Child> children;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Note> notes;

    public Teacher() {}

    public Teacher(String nome, String cognome, String classe, String email, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.classe = classe;
        this.email = email;
        this.telefono = telefono;
    }

  
}
