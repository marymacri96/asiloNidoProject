package com.asilo.nido.gestione.asilo.repository;

import com.asilo.nido.gestione.asilo.entity.Attendance;
import com.asilo.nido.gestione.asilo.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByChild(Child child);

    List<Attendance> findByData(LocalDate data);
}
