package com.asilo.nido.gestione.asilo.repository;

import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {

    List<Child> findByTeacher(Teacher teacher);

    List<Child> findByClasse(String classe);
}
