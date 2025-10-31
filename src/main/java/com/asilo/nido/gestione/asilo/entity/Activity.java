package com.asilo.nido.gestione.asilo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "activity")
@Data
public class Activity implements Serializable {

    
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "ActivitySequence", sequenceName = "ACTIVITY_ID_ACTIVITY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ActivitySequence")
	@Column(name = "id_activity", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "descrizione", length = 500)
    private String descrizione;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    // Relazione ManyToOne con Teacher
    /*@ManyToOne
    @JoinColumn(name = "id_teacher")
    @JsonIgnoreProperties("activities")
    private Teacher teacher;*/

    public Activity() {}

    public Activity(String nome, String descrizione, LocalDate data, Teacher teacher) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
       // this.teacher = teacher;
    }

  
}
