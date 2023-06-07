package com.clubmanagement.app.controller;

import com.clubmanagement.app.entity.Coach;
import com.clubmanagement.app.service.coach.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    private CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping
    public List<Coach> findAll() {
        return coachService.findAll();
    }

    @GetMapping("/{id}")
    public Coach coach (@PathVariable Long id) {
        Coach coach = coachService.findById(id);
        if (id == null) {
            throw new RuntimeException("Coach id not found - " + id);
        }
        return coach;
    }

    @PostMapping
    public Coach addCoach(@RequestBody Coach coach) {
        coach.setId(0L);
        Coach dbCoach = coachService.save(coach);
        return dbCoach;
    }

    @PutMapping
    public Coach updateCoach(@RequestBody Coach coach) {
        return coachService.save(coach);
    }

    @DeleteMapping("/{id}")
    public String deleteCoach(@PathVariable Long id) {
        Coach coach = coachService.findById(id);
        if(coach == null) {
            throw new RuntimeException("Coach not found id - " + id);
        }
        coachService.deleteById(id);
        return "Deleted coach: " + coach.getName();
    }
}
