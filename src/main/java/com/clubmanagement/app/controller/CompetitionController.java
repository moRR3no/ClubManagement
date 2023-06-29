package com.clubmanagement.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

//    private CompetitionService competitionService;
//
//    @Autowired
//    public CompetitionController(CompetitionService competitionService) {
//        this.competitionService = competitionService;
//    }
//
//    @GetMapping
//    public List<Competition> findAll() {
//        return competitionService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Competition competition (@PathVariable Long id) {
//        Competition competition = competitionService.findById(id);
//        if (id == null) {
//            throw new RuntimeException("Competition id not found - " + id);
//        }
//        return competition;
//    }
//
//    @PostMapping
//    public Competition addCompetition(@RequestBody Competition competition) {
//        competition.setId(0L);
//        Competition dbCompetition = competitionService.save(competition);
//        return dbCompetition;
//    }
//
//    @PutMapping
//    public Competition updateCompetition(@RequestBody Competition competition) {
//        return competitionService.save(competition);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteCompetition(@PathVariable Long id) {
//        Competition competition = competitionService.findById(id);
//        if(competition == null) {
//            throw new RuntimeException("Competition not found id - " + id);
//        }
//        competitionService.deleteById(id);
//        return "Deleted competition: " + competition.getName();
//    }
}
