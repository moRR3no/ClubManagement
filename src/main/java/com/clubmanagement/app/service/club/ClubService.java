package com.clubmanagement.app.service.club;

import com.clubmanagement.app.repository.club.Club;

import java.util.List;

public interface ClubService {

    List<Club> findAll();
    Club findById(Long id);
    Club save(Club theClub);
    void deleteById(Long id);
}
