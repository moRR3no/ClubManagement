package com.clubmanagement.app.controller;

import com.clubmanagement.app.repository.player.Player;
import com.clubmanagement.app.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> findAll() {
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Player player (@PathVariable Long id) {
        Player player = playerService.findById(id);
        if (id == null) {
            throw new RuntimeException("Player id not found - " + id);
        }
        return player;
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0L);
        Player dbPlayer = playerService.save(player);
        return dbPlayer;
    }

    @PutMapping
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.save(player);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id) {
        Player player = playerService.findById(id);
        if(player == null) {
            throw new RuntimeException("Player not found id - " + id);
        }
        playerService.deleteById(id);
        return "Deleted player: " + player.getName();
    }
}
