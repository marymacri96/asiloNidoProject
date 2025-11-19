package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.ChildDTO;
import com.asilo.nido.gestione.asilo.entity.Child;
import com.asilo.nido.gestione.asilo.mapper.ChildMapper;
import com.asilo.nido.gestione.asilo.service.ChildService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    private final ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public ResponseEntity<List<ChildDTO>> getAllChildren() {
        List<ChildDTO> children = childService.getAllChildren()
                .stream()
                .map(ChildMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(children);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildDTO> getChildById(@PathVariable Long id) {
        Child child = childService.getChildById(id);
        return ResponseEntity.ok(ChildMapper.toDTO(child));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<ChildDTO>> getChildrenByTeacher(@PathVariable Long teacherId) {
        List<ChildDTO> children = childService.getChildrenByTeacher(teacherId)
                .stream()
                .map(ChildMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(children);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ChildDTO> createChild(@RequestBody ChildDTO childDTO) {
        Child child = ChildMapper.toEntity(childDTO);
        Child created = childService.createChild(child);
        return new ResponseEntity<>(ChildMapper.toDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChildDTO> updateChild(@PathVariable Long id, @RequestBody ChildDTO childDTO) {
        Child childDetails = ChildMapper.toEntity(childDTO);
        Child updated = childService.updateChild(id, childDetails);
        return ResponseEntity.ok(ChildMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteChild(@PathVariable Long id) {
        childService.deleteChild(id);
    }
}
