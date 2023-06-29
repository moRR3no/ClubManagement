package com.clubmanagement.app.service.player;

import com.clubmanagement.app.entity.Player;

import java.util.List;
import java.util.Set;

public interface PlayerService {
    List<Player> findAll();
    Player findById(Long id);
    Player save(Player thePlayer);

    void savePlayers (Set<Player> players);
    void deleteById(Long id);
}
