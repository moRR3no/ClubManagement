package com.clubmanagement.app.service.coach;

import com.clubmanagement.app.entity.Coach;

import java.util.List;

public interface CoachService {

    List<Coach> findAll();
    Coach findById(Long id);
    Coach save(Coach theCoach);
    void deleteById(Long id);
}
