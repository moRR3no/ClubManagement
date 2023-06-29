package com.clubmanagement.app.service.player;

import com.clubmanagement.app.entity.Player;
import com.clubmanagement.app.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        Optional<Player> result = playerRepository.findById(id);
        Player thePlayer = null;
        if (result.isPresent()) {
            thePlayer = result.get();
        } else {
            throw new RuntimeException("Did not found player id - " + id);
        }
        return thePlayer;
    }

    @Override
    public Player save(Player thePlayer) {
        return playerRepository.save(thePlayer);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void savePlayers(Set<Player> players) {
        for (Player p : players) {
            save(p);
        }
    }
}
