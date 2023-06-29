package com.clubmanagement.app.controller;

import com.clubmanagement.app.entity.Club;
import com.clubmanagement.app.entity.Player;
import com.clubmanagement.app.exception.ResourceNotFoundException;
import com.clubmanagement.app.repository.ClubRepository;
import com.clubmanagement.app.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ClubController {


    private ClubRepository clubRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public ClubController(ClubRepository clubRepository, PlayerRepository playerRepository) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/clubs")
    public ResponseEntity<List<Club>> getAllClubsOrOneClub(@RequestParam(required = false) String name) {
        List<Club> clubs = new ArrayList<>();

        if (name == null) {
            clubs.addAll(clubRepository.findAll());
        } else {
            clubs.addAll(clubRepository.findByName(name));
        }

        if (clubs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping("/clubs/{id}")
    public ResponseEntity<Club> getClubById (@PathVariable("id") Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + id));
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @PostMapping("/clubs")
    public ResponseEntity<Club> createClub (@RequestBody Club club) {
        return new ResponseEntity<>(clubRepository.save(new Club(club.getName())), HttpStatus.CREATED);
    }

    @PutMapping("/clubs/{id}")
    public ResponseEntity<Club> updateClub (@PathVariable("id") Long id, @RequestBody Club club) {
        Club tempClub = clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + id));
        tempClub.setName(club.getName());
        return new ResponseEntity<>(clubRepository.save(tempClub), HttpStatus.OK);
    }

    @DeleteMapping("/clubs/{id}")
    public ResponseEntity<HttpStatus> deleteClubById (@PathVariable("id") Long id) {
        Club tempClub = clubRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + id));
        List<Player> players = playerRepository.findByClubId(id);
        if (!players.isEmpty()) {
            for (Player p : players) {
                p.setClub(clubRepository.findById(1L).get());
                p.setNumber(0);
                playerRepository.save(p);
            }
        }
        clubRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/clubs")
    public ResponseEntity<HttpStatus> deleteAllClubs () {
        clubRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    private ClubService clubService;
//
//    @Autowired
//    public ClubController(ClubService clubService) {
//        this.clubService = clubService;
//    }
//
//    @GetMapping
//    public List<Club> findAll() {
//        return clubService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Club club (@PathVariable Long id) {
//        Club club = clubService.findById(id);
//        if (id == null) {
//            throw new RuntimeException("Club id not found - " + id);
//        }
//        return club;
//    }
//
//    @PostMapping
//    public Club addClub(@RequestBody Club club) {
//        club.setId(0L);
//        Club dbClub = clubService.save(club);
//        return dbClub;
//    }
//
//    @PutMapping
//    public Club updateClub(@RequestBody Club club) {
//        return clubService.save(club);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteClub(@PathVariable Long id) {
//        Club club = clubService.findById(id);
//        if(club == null) {
//            throw new RuntimeException("Club not found id - " + id);
//        }
//        clubService.deleteById(id);
//        return "Deleted club: " + club.getName();
//    }
}
