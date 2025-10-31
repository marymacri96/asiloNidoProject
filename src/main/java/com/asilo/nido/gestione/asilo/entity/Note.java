package com.asilo.nido.gestione.asilo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "note")
@Data
public class Note implements Serializable {

    
	private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "NoteSequence", sequenceName = "NOTE_ID_NOTE_SEQ", allocationSize = 1)
   	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NoteSequence")
    @Column(name = "id_note")
    private Long id;

    @Column(name = "testo", nullable = false, length = 500)
    private String testo;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    // Relazione ManyToOne con Child
    @ManyToOne
    @JoinColumn(name = "id_child", nullable = false)
    @JsonIgnoreProperties("notes")
    private Child child;

    // Relazione ManyToOne con Teacher
    @ManyToOne
    @JoinColumn(name = "id_teacher", nullable = false)
    @JsonIgnoreProperties("notes")
    private Teacher teacher;

    public Note() {}

    public Note(String testo, LocalDate data, Child child, Teacher teacher) {
        this.testo = testo;
        this.data = data;
        this.child = child;
        this.teacher = teacher;
    }

  
}