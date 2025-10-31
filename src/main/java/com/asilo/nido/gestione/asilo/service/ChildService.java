package com.asilo.nido.gestione.asilo.service;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.repository.ChildRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
	@Autowired
    private  ChildRepository childRepository;


    // 🔹 Salva un nuovo Child
    public Child saveChild(Child child) {
        return childRepository.save(child);
    }

    // 🔹 Aggiorna un Child esistente
    public Child updateChild(Long id, Child updatedChild) {
        Optional<Child> optionalChild = childRepository.findById(id);

        if (optionalChild.isPresent()) {
            Child existingChild = optionalChild.get();

            // Aggiornamento dei campi
            existingChild.setNome(updatedChild.getNome());
            existingChild.setCognome(updatedChild.getCognome());
            existingChild.setDataNascita(updatedChild.getDataNascita());
            existingChild.setClasse(updatedChild.getClasse());
            existingChild.setEmail(updatedChild.getEmail());
            existingChild.setTelefono(updatedChild.getTelefono());
            existingChild.setTeacher(updatedChild.getTeacher()); // relazione N:1 con Teacher

            return childRepository.save(existingChild);
        } else {
            throw new RuntimeException("Child non trovato con id: " + id);
        }
    }

    // 🔹 Recupera tutti i Child
    public List<Child> getAllChildren() {
        return childRepository.findAll();
    }

    // 🔹 Recupera un Child per ID
    public Optional<Child> getChildById(Long id) {
        return childRepository.findById(id);
    }

    // 🔹 Elimina un Child per ID
    public void deleteChildById(Long id) {
        childRepository.deleteById(id);
    }

    // 🔹 Ricerca per nome
    public List<Child> getChildrenByNome(String nome) {
        return childRepository.findByNome(nome);
    }

    // 🔹 Ricerca per cognome
    public List<Child> getChildrenByCognome(String cognome) {
        return childRepository.findByCognome(cognome);
    }

    // 🔹 Ricerca per classe
    public List<Child> getChildrenByClasse(String classe) {
        return childRepository.findByClasse(classe);
    }

    // 🔹 Ricerca per nome parziale
    public List<Child> getChildrenByNomePartial(String partialNome) {
        return childRepository.findByNomeContainingIgnoreCase(partialNome);
    }

    // 🔹 Ricerca per cognome parziale
    public List<Child> getChildrenByCognomePartial(String partialCognome) {
        return childRepository.findByCognomeContainingIgnoreCase(partialCognome);
    }
} 