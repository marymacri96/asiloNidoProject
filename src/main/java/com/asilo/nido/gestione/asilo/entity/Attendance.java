package com.asilo.nido.gestione.asilo.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Data
public class Attendance implements Serializable {

    
	private static final long serialVersionUID = 1L;
	
    @Id
    @SequenceGenerator(name = "AttendanceSequence", sequenceName = "ATTENDANCE_ID_ATTENDANCE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AttendanceSequence")
    @Column(name = "id_attendance",unique=true,nullable=false)
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "presente", nullable = false)
    private Boolean presente;

    // Relazione N:1 con Child
    @ManyToOne
    @JoinColumn(name = "id_child", nullable = false)
    private Child child;

    // Costruttori
    public Attendance() {}

    public Attendance(LocalDate data, Boolean presente, Child child) {
        this.data = data;
        this.presente = presente;
        this.child = child;
    }

   
}