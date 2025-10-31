package com.asilo.nido.gestione.asilo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asilo.nido.gestione.asilo.entity.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByEmail(String email);

    List<Teacher> findByNome(String nome);

    List<Teacher> findByCognome(String cognome);

    List<Teacher> findByClasse(String classe);

    List<Teacher> findByNomeContainingIgnoreCase(String partialNome);

    List<Teacher> findByCognomeContainingIgnoreCase(String partialCognome);
}
