package com.asilo.nido.gestione.asilo.mapper;

import com.asilo.nido.gestione.asilo.dto.ActivityDTO;
import com.asilo.nido.gestione.asilo.entity.Activity;

public class ActivityMapper {

    public static ActivityDTO toDTO(Activity activity) {
        return new ActivityDTO(
                activity.getId(),
                activity.getNome(),
                activity.getDescrizione()
        );
    }

    public static Activity toEntity(ActivityDTO dto) {
        Activity activity = new Activity();
        activity.setId(dto.getId());
        activity.setNome(dto.getNome());
        activity.setDescrizione(dto.getDescrizione());
        return activity;
    }
}
