package com.asilo.nido.gestione.asilo.dto;

import java.time.LocalDate;

public class AttendanceDTO {

    private Long id;
    private LocalDate data;
    private Boolean presente;
    private Long childId;

    public AttendanceDTO() {
    }

    public AttendanceDTO(Long id, LocalDate data, Boolean presente, Long childId) {
        this.id = id;
        this.data = data;
        this.presente = presente;
        this.childId = childId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }
}
