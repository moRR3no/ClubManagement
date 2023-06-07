package com.clubmanagement.app.service.competition;

import com.clubmanagement.app.entity.Competition;
import com.clubmanagement.app.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionServiceImpl(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    @Override
    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    @Override
    public Competition findById(Long id) {
        Optional<Competition> result = competitionRepository.findById(id);
        Competition theCompetition = null;
        if(result.isPresent()) {
            theCompetition=result.get();
        }
        else {
            throw new RuntimeException("Did not found competition id - " + id);
        }
        return theCompetition;
    }

    @Override
    public Competition save(Competition theCompetition) {
        return competitionRepository.save(theCompetition);
    }

    @Override
    public void deleteById(Long id) {
        competitionRepository.deleteById(id);
    }
}
