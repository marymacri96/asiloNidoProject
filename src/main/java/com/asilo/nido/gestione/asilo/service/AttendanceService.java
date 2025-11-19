package com.asilo.nido.gestione.asilo.service;

import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.exception.AttendanceNotFoundException;
import com.asilo.nido.gestione.asilo.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new AttendanceNotFoundException(id));
    }

    public List<Attendance> getAttendancesByChild(Child child) {
        return attendanceRepository.findByChild(child);
    }

    public List<Attendance> getAttendancesByDate(LocalDate data) {
        return attendanceRepository.findByData(data);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
        Attendance attendance = getAttendanceById(id);

        attendance.setData(attendanceDetails.getData());
        attendance.setPresente(attendanceDetails.getPresente());
        attendance.setChild(attendanceDetails.getChild());

        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        Attendance attendance = getAttendanceById(id);
        attendanceRepository.delete(attendance);
    }
}
