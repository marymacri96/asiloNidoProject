package com.asilo.nido.gestione.asilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.service.ChildService;

import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {
	@Autowired
    private  ChildService childService;

    // CREATE
    @PostMapping
    public ResponseEntity<Child> createChild(@RequestBody Child child) {
        Child savedChild = childService.saveChild(child);
        return new ResponseEntity<>(savedChild, HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Child>> getAllChildren() {
        return ResponseEntity.ok(childService.getAllChildren());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Child> getChildById(@PathVariable Long id) {
        return childService.getChildById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Child> updateChild(@PathVariable Long id, @RequestBody Child child) {
        try {
            Child updatedChild = childService.updateChild(id, child);
            return ResponseEntity.ok(updatedChild);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChild(@PathVariable Long id) {
        childService.deleteChildById(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH BY NOME
    @GetMapping("/search/nome")
    public ResponseEntity<List<Child>> getChildrenByNome(@RequestParam String nome) {
        return ResponseEntity.ok(childService.getChildrenByNome(nome));
    }

    // SEARCH BY COGNOME
    @GetMapping("/search/cognome")
    public ResponseEntity<List<Child>> getChildrenByCognome(@RequestParam String cognome) {
        return ResponseEntity.ok(childService.getChildrenByCognome(cognome));
    }

    // SEARCH BY CLASSE
    @GetMapping("/search/classe")
    public ResponseEntity<List<Child>> getChildrenByClasse(@RequestParam String classe) {
        return ResponseEntity.ok(childService.getChildrenByClasse(classe));
    }

    // SEARCH BY NOME PARZIALE
    @GetMapping("/search/nome-partial")
    public ResponseEntity<List<Child>> getChildrenByNomePartial(@RequestParam String nome) {
        return ResponseEntity.ok(childService.getChildrenByNomePartial(nome));
    }

    // SEARCH BY COGNOME PARZIALE
    @GetMapping("/search/cognome-partial")
    public ResponseEntity<List<Child>> getChildrenByCognomePartial(@RequestParam String cognome) {
        return ResponseEntity.ok(childService.getChildrenByCognomePartial(cognome));
    }
}