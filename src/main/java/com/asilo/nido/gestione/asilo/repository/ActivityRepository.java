package com.asilo.nido.gestione.asilo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asilo.nido.gestione.asilo.entity.Activity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    //List<Activity> findByTeacherIdTeacher(Long idTeacher);

    List<Activity> findByData(LocalDate data);

    List<Activity> findByNomeContainingIgnoreCase(String partialNome);

    List<Activity> findByDataBetween(LocalDate startDate, LocalDate endDate);
}