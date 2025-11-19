package com.asilo.nido.gestione.asilo.service;

import com.asilo.nido.gestione.asilo.entity.Activity;
import com.asilo.nido.gestione.asilo.exception.ActivityNotFoundException;
import com.asilo.nido.gestione.asilo.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivityById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ActivityNotFoundException(id));
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity activityDetails) {
        Activity activity = getActivityById(id);

        activity.setNome(activityDetails.getNome());
        activity.setDescrizione(activityDetails.getDescrizione());
        activity.setData(activityDetails.getData());

        return activityRepository.save(activity);
    }

    public void deleteActivity(Long id) {
        Activity activityRepositoryById = getActivityById(id);
        activityRepository.delete(activityRepositoryById);
    }
}
