package com.asilo.nido.gestione.asilo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.repository.AttendanceRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
	@Autowired
    private  AttendanceRepository attendanceRepository;

 
    // Salva una nuova attendance
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Aggiorna una attendance esistente
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        return attendanceRepository.findById(id).map(existing -> {
            existing.setData(updatedAttendance.getData());
            existing.setPresente(updatedAttendance.getPresente());
            existing.setChild(updatedAttendance.getChild());
            return attendanceRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Attendance non trovata con id: " + id));
    }

    // Recupera tutte le attendance
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // Recupera attendance per ID
    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    // Elimina attendance per ID
    public void deleteAttendanceById(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Recupera tutte le attendance di un bambino
   /* public List<Attendance> getAttendancesByChildId(Long idChild) {
        return attendanceRepository.findByChildIdChild(idChild);
    }

    // Recupera attendance di un bambino in un intervallo di date
    public List<Attendance> getAttendancesByChildIdAndDateRange(Long idChild, LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findByChildIdChildAndDataBetween(idChild, startDate, endDate);
    }*/
}
