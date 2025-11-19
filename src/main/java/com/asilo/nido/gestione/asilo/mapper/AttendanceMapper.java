package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.AttendanceDTO;
import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.entity.Child;

public class AttendanceMapper {

    public static AttendanceDTO toDTO(Attendance attendance) {
        Long childId = attendance.getChild() != null ? attendance.getChild().getId() : null;
        return new AttendanceDTO(
                attendance.getId(),
                attendance.getData(),
                attendance.getPresente(),
                childId
        );
    }

    public static Attendance toEntity(AttendanceDTO dto, Child child) {
        Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
        attendance.setData(dto.getData());
        attendance.setPresente(dto.getPresente());
        attendance.setChild(child);
        return attendance;
    }
}
