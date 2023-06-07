package com.clubmanagement.app.service.club;

import com.clubmanagement.app.entity.Club;
import com.clubmanagement.app.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    @Override
    public Club findById(Long id) {
        Optional<Club> result = clubRepository.findById(id);
        Club theClub = null;
        if(result.isPresent()) {
            theClub=result.get();
        }
        else {
            throw new RuntimeException("Did not found club id - " + id);
        }
        return theClub;
    }

    @Override
    public Club save(Club theClub) {
        return clubRepository.save(theClub);
    }

    @Override
    public void deleteById(Long id) {
        clubRepository.deleteById(id);
    }
}
