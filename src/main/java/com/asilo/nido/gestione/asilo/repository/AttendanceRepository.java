package com.asilo.nido.gestione.asilo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asilo.nido.gestione.asilo.entity.Attendance;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    //List<Attendance> findByChildIdChild(Long idChild);

   // List<Attendance> findByChildIdChildAndDataBetween(Long idChild, LocalDate startDate, LocalDate endDate);
}
