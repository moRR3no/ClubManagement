package com.clubmanagement.app.controller;

import com.clubmanagement.app.repository.club.Club;
import com.clubmanagement.app.service.club.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController{

    private ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> findAll() {
        return clubService.findAll();
    }

    @GetMapping("/{id}")
    public Club club (@PathVariable Long id) {
        Club club = clubService.findById(id);
        if (id == null) {
            throw new RuntimeException("Club id not found - " + id);
        }
        return club;
    }

    @PostMapping
    public Club addClub(@RequestBody Club club) {
        club.setId(0L);
        Club dbClub = clubService.save(club);
        return dbClub;
    }

    @PutMapping
    public Club updateClub(@RequestBody Club club) {
        return clubService.save(club);
    }

    @DeleteMapping("/{id}")
    public String deleteClub(@PathVariable Long id) {
        Club club = clubService.findById(id);
        if(club == null) {
            throw new RuntimeException("Club not found id - " + id);
        }
        clubService.deleteById(id);
        return "Deleted club: " + club.getName();
    }
}
