package com.asilo.nido.gestione.asilo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asilo.nido.gestione.asilo.entity.Child;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByNome(String nome);

    List<Child> findByCognome(String cognome);

    List<Child> findByClasse(String classe);

    Optional<Child> findByEmail(String email);

    List<Child> findByNomeContainingIgnoreCase(String partialNome);

    List<Child> findByCognomeContainingIgnoreCase(String partialCognome);
}