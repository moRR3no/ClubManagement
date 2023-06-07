package com.clubmanagement.app.service.competition;

import com.clubmanagement.app.entity.Competition;

import java.util.List;

public interface CompetitionService {

    List<Competition> findAll();
    Competition findById(Long id);
    Competition save(Competition theCompetition);
    void deleteById(Long id);
}
