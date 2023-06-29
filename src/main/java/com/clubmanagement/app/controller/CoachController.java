package com.clubmanagement.app.controller;

import com.clubmanagement.app.entity.Club;
import com.clubmanagement.app.entity.Coach;
import com.clubmanagement.app.exception.ResourceNotFoundException;
import com.clubmanagement.app.repository.ClubRepository;
import com.clubmanagement.app.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CoachController {

    private CoachRepository coachRepository;
    private ClubRepository clubRepository;

    @Autowired
    public CoachController(CoachRepository coachRepository, ClubRepository clubRepository) {
        this.coachRepository = coachRepository;
        this.clubRepository = clubRepository;
    }


    @GetMapping("/clubs/{clubId}/coaches")
    public ResponseEntity<Coach> getCoachByClub (@PathVariable("clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new ResourceNotFoundException("Club not found with id = " + clubId);
        }
        Coach coach = coachRepository.findByClubId(clubId);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @GetMapping("/coaches/{id}")
    public ResponseEntity<Coach> getCoachById (@PathVariable("id") Long id) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id = " + id));
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @GetMapping("/coaches")
    public ResponseEntity<List<Coach>> getAllCoaches () {
        List<Coach> coaches = new ArrayList<>(coachRepository.findAll());
        if (coaches.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @PostMapping("/clubs/{clubId}/coaches")
    public ResponseEntity<Coach> createCoach (@PathVariable("clubId") Long clubId, @RequestBody Coach coach) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + clubId));

        coach.setClub(club);
        return new ResponseEntity<>(coachRepository.save(coach), HttpStatus.CREATED);
    }

    @PutMapping("/coaches/{id}")
    public ResponseEntity<Coach> updateCoachById (@PathVariable("id") Long id, @RequestBody Coach coachRequest) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coach not found with id = " + id));
        coach.setName(coachRequest.getName());
        coach.setNationality(coachRequest.getNationality());

        return new ResponseEntity<>(coachRepository.save(coach), HttpStatus.OK);
    }

    @DeleteMapping("/coaches/{id}")
    public ResponseEntity<HttpStatus> deleteCoachById (@PathVariable("id") Long id) {
        coachRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/clubs/{clubId}/coaches")
    public ResponseEntity<HttpStatus> deleteCoachByClub (@PathVariable("clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new ResourceNotFoundException("Club not found with id = " + clubId);
        }
        coachRepository.deleteByClubId(clubId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



    //    private CoachService coachService;
//
//    @Autowired
//    public CoachController(CoachService coachService) {
//        this.coachService = coachService;
//    }
//
//    @GetMapping
//    public List<Coach> findAll() {
//        return coachService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Coach coach (@PathVariable Long id) {
//        Coach coach = coachService.findById(id);
//        if (id == null) {
//            throw new RuntimeException("Coach id not found - " + id);
//        }
//        return coach;
//    }
//
//    @PostMapping
//    public Coach addCoach(@RequestBody Coach coach) {
//        coach.setId(0L);
//        Coach dbCoach = coachService.save(coach);
//        return dbCoach;
//    }
//
//    @PutMapping
//    public Coach updateCoach(@RequestBody Coach coach) {
//        return coachService.save(coach);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCoach(@PathVariable Long id) {
//        Coach coach = coachService.findById(id);
//        if(coach == null) {
//            throw new RuntimeException("Coach not found id - " + id);
//        }
//        coachService.deleteById(id);
//        return "Deleted coach: " + coach.getName();
//    }
}
