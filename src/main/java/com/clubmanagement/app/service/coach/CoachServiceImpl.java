package com.clubmanagement.app.service.coach;

import com.clubmanagement.app.repository.coach.Coach;
import com.clubmanagement.app.repository.coach.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {

    private final CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach findById(Long id) {
        Optional<Coach> result = coachRepository.findById(id);
        Coach theCoach = null;
        if(result.isPresent()) {
            theCoach=result.get();
        }
        else {
            throw new RuntimeException("Did not found coach id - " + id);
        }
        return theCoach;
    }

    @Override
    public Coach save(Coach theCoach) {
        return coachRepository.save(theCoach);
    }

    @Override
    public void deleteById(Long id) {
        coachRepository.deleteById(id);
    }
}
