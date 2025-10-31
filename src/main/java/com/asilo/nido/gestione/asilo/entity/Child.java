package com.asilo.nido.gestione.asilo.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "child")
@Data
public class Child implements Serializable {

    
	private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "ChildSequence", sequenceName = "CHILD_ID_CHILD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ChildSequence")
    @Column(name = "id_child",unique=true,nullable=false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "data_nascita", nullable = false)
    private LocalDate dataNascita;

    @Column(name = "classe", length = 20)
    private String classe;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    // Relazioni

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> attendances;

    /*@OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activity> activities;*/

    // Costruttori

    public Child() {}

    public Child(String nome, String cognome, LocalDate dataNascita, String classe, String email, String telefono, Teacher teacher) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.classe = classe;
        this.email = email;
        this.telefono = telefono;
        this.teacher = teacher;
    }

    
}