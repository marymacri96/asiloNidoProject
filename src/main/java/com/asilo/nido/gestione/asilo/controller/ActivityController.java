package com.asilo.nido.gestione.asilo.controller;

import com.asilo.nido.gestione.asilo.dto.ActivityDTO;
import com.asilo.nido.gestione.asilo.entity.Activity;
import com.asilo.nido.gestione.asilo.mapper.ActivityMapper;
import com.asilo.nido.gestione.asilo.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getAllActivities() {
        List<ActivityDTO> activities = activityService.getAllActivities()
                .stream()
                .map(ActivityMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(activities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getActivityById(@PathVariable Long id) {
        Activity activity = activityService.getActivityById(id);
        return ResponseEntity.ok(ActivityMapper.toDTO(activity));
    }

    @PostMapping
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO dto) {
        Activity activity = ActivityMapper.toEntity(dto);
        Activity created = activityService.createActivity(activity);
        return new ResponseEntity<>(ActivityMapper.toDTO(created), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable Long id, @RequestBody ActivityDTO dto) {
        Activity activityDetails = ActivityMapper.toEntity(dto);
        Activity updated = activityService.updateActivity(id, activityDetails);
        return ResponseEntity.ok(ActivityMapper.toDTO(updated));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteActivity(@PathVariable Long id) {
        activityService.deleteActivity(id);
    }
}
