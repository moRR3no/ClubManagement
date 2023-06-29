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

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {


    private ClubRepository clubRepository;

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerController(ClubRepository clubRepository, PlayerRepository playerRepository) {
        this.clubRepository = clubRepository;
        this.playerRepository = playerRepository;
    }

    @GetMapping("/clubs/{clubId}/players")
    public ResponseEntity<List<Player>> getPlayersByClubId(@PathVariable("clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new ResourceNotFoundException("Club not found with id = " + clubId);
        }
        List<Player> players = playerRepository.findByClubId(clubId);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> getPlayerById (@PathVariable("id") Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id = " + id));
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping("/clubs/{clubId}/players")
    public ResponseEntity<Player> createPlayer (@PathVariable("clubId") Long clubId, @RequestBody Player playerRequest) {
        Player player = clubRepository.findById(clubId).map(club -> {
            playerRequest.setClub(club);
            return playerRepository.save(playerRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + clubId));

        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer (@PathVariable("id") Long id, @RequestBody Player playerRequest) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id = " + id));
        player.setName(playerRequest.getName());
        player.setNumber(playerRequest.getNumber());
        player.setNationality(playerRequest.getNationality());

        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

    @PatchMapping("/players/{playerId}/transfer/{clubId}")
    public ResponseEntity<Player> transferPlayer (@PathVariable("playerId") Long playerId,
                                                  @PathVariable("clubId") Long clubId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with id = " + playerId));
        Club destinationClub = clubRepository.findById(clubId)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found with id = " + clubId));
        player.setClub(destinationClub);

        return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<HttpStatus> deletePlayerById (@PathVariable("id") Long id) {
        playerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/clubs/{clubId}/players")
    public ResponseEntity<HttpStatus> deleteAllPlayersOfClub (@PathVariable("clubId") Long clubId) {
        if (!clubRepository.existsById(clubId)) {
            throw new ResourceNotFoundException("Club not found with id = " + clubId);
        }
        playerRepository.deleteByClubId(clubId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //    private PlayerService playerService;
//
//    @Autowired
//    public PlayerController(PlayerService playerService) {
//        this.playerService = playerService;
//    }
//
//    @GetMapping
//    public List<Player> findAll() {
//        return playerService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Player player (@PathVariable Long id) {
//        Player player = playerService.findById(id);
//        if (id == null) {
//            throw new RuntimeException("Player id not found - " + id);
//        }
//        return player;
//    }
//
//    @PostMapping
//    public Player addPlayer(@RequestBody Player player) {
//        player.setId(0L);
//        Player dbPlayer = playerService.save(player);
//        return dbPlayer;
//    }
//
//    @PutMapping
//    public Player updatePlayer(@RequestBody Player player) {
//        return playerService.save(player);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deletePlayer(@PathVariable Long id) {
//        Player player = playerService.findById(id);
//        if(player == null) {
//            throw new RuntimeException("Player not found id - " + id);
//        }
//        playerService.deleteById(id);
//        return "Deleted player: " + player.getName();
//    }
}
