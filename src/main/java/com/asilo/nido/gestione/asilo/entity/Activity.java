package com.asilo.nido.gestione.asilo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "activity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Activity implements Serializable {

    @Id
    @SequenceGenerator(name = "ActivitySequence", sequenceName = "ACTIVITY_ID_ACTIVITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ActivitySequence")
    @Column(name = "id_activity", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 500)
    private String descrizione;

    @Column(nullable = false)
    private LocalDate data;

    @ManyToMany(mappedBy = "activities")
    private List<Child> children;

    public Activity() {}

    // GETTER & SETTER
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public List<Child> getChildren() { return children; }
    public void setChildren(List<Child> children) { this.children = children; }
}
