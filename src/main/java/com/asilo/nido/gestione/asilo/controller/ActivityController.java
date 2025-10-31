package com.asilo.nido.gestione.asilo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asilo.nido.gestione.asilo.entity.Activity;
import com.asilo.nido.gestione.asilo.service.ActivityService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	
	// CREATE
	@PostMapping
	public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
		Activity savedActivity = activityService.saveActivity(activity);
		return new ResponseEntity<>(savedActivity, HttpStatus.CREATED);
	}

	// READ ALL
	@GetMapping
	public ResponseEntity<List<Activity>> getAllActivities() {
		return ResponseEntity.ok(activityService.getAllActivities());
	}

	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
		return activityService.getActivityById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	// UPDATE
	@PutMapping("/{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
		try {
			Activity updated = activityService.updateActivity(id, activity);
			return ResponseEntity.ok(updated);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	// DELETE
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteActivity(@PathVariable Long id) {
		activityService.deleteActivityById(id);
		return ResponseEntity.noContent().build();
	}

	// FILTER BY TEACHER ID
	/*
	 * @GetMapping("/teacher/{idTeacher}") public ResponseEntity<List<Activity>>
	 * getActivitiesByTeacher(@PathVariable Long idTeacher) { return
	 * ResponseEntity.ok(activityService.getActivitiesByTeacherId(idTeacher)); }
	 */

	// FILTER BY PARTIAL NAME
	@GetMapping("/search")
	public ResponseEntity<List<Activity>> getActivitiesByNome(@RequestParam String nome) {
		return ResponseEntity.ok(activityService.getActivitiesByNomePartial(nome));
	}

	// FILTER BY DATE
	@GetMapping("/date/{date}")
	public ResponseEntity<List<Activity>> getActivitiesByDate(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		return ResponseEntity.ok(activityService.getActivitiesByData(date));
	}

	// FILTER BY DATE RANGE
	@GetMapping("/daterange")
	public ResponseEntity<List<Activity>> getActivitiesByDateRange(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
		return ResponseEntity.ok(activityService.getActivitiesByDateRange(start, end));
	}
}