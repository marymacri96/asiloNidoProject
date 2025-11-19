package com.asilo.nido.gestione.asilo.dto;

public class NoteDTO {

    private Long id;
    private String testo;
    private Long childId;
    private Long teacherId;

    public NoteDTO() {
    }

    public NoteDTO(Long id, String testo, Long childId, Long teacherId) {
        this.id = id;
        this.testo = testo;
        this.childId = childId;
        this.teacherId = teacherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }
}
