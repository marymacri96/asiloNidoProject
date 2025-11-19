package com.asilo.nido.gestione.asilo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendance implements Serializable {

    @Id
    @SequenceGenerator(name = "AttendanceSequence", sequenceName = "ATTENDANCE_ID_ATTENDANCE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AttendanceSequence")
    @Column(name = "id_attendance", unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private Boolean presente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_child", nullable = false)
    @JsonIgnore
    private Child child;

    public Attendance() {}

    // GETTER & SETTER
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }

    public Child getChild() { return child; }
    public void setChild(Child child) { this.child = child; }
}
