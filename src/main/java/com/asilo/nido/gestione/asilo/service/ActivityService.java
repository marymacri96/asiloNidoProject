package com.asilo.nido.gestione.asilo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asilo.nido.gestione.asilo.entity.Activity;
import com.asilo.nido.gestione.asilo.repository.ActivityRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {
	@Autowired
    private ActivityRepository activityRepository;


    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity updatedActivity) {
        return activityRepository.findById(id)
                .map(existing -> {
                    existing.setNome(updatedActivity.getNome());
                    existing.setData(updatedActivity.getData());
                    //existing.setTeacher(updatedActivity.getTeacher());
                    existing.setDescrizione(updatedActivity.getDescrizione());
                    return activityRepository.save(existing);
                }).orElseThrow(() -> new RuntimeException("Activity non trovato con id: " + id));
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    public void deleteActivityById(Long id) {
        activityRepository.deleteById(id);
    }

    /*public List<Activity> getActivitiesByTeacherId(Integer idTeacher) {
        return activityRepository.findByTeacherIdTeacher(idTeacher);
    }*/

    public List<Activity> getActivitiesByNomePartial(String partialNome) {
        return activityRepository.findByNomeContainingIgnoreCase(partialNome);
    }

    public List<Activity> getActivitiesByData(LocalDate data) {
        return activityRepository.findByData(data);
    }

    public List<Activity> getActivitiesByDateRange(LocalDate startDate, LocalDate endDate) {
        return activityRepository.findByDataBetween(startDate, endDate);
    }
}

