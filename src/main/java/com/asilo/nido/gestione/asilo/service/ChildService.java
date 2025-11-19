package com.asilo.nido.gestione.asilo.service;

import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.entity.Teacher;
import com.asilo.nido.gestione.asilo.exception.ChildNotFoundException;
import com.asilo.nido.gestione.asilo.repository.ChildRepository;
import com.asilo.nido.gestione.asilo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildService {

    private final ChildRepository childRepository;
    private final TeacherRepository teacherRepository;

    public ChildService(ChildRepository childRepository, TeacherRepository teacherRepository) {
        this.childRepository = childRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    public Child getChildById(Long id) {
        return childRepository.findById(id)
                .orElseThrow(() -> new ChildNotFoundException(id));
    }

    public List<Child> getChildrenByTeacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher non trovato con id: " + teacherId));
        return childRepository.findByTeacher(teacher);
    }

    public Child createChild(Child child) {
        return childRepository.save(child);
    }

    public Child updateChild(Long id, Child childDetails) {
        Child child = getChildById(id);

        child.setNome(childDetails.getNome());
        child.setCognome(childDetails.getCognome());
        child.setDataNascita(childDetails.getDataNascita());
        child.setClasse(childDetails.getClasse());
        child.setEmail(childDetails.getEmail());
        child.setTelefono(childDetails.getTelefono());
        child.setTeacher(childDetails.getTeacher());

        return childRepository.save(child);
    }

    public void deleteChild(Long id) {
        Child child = getChildById(id);
        childRepository.delete(child);
    }
}
