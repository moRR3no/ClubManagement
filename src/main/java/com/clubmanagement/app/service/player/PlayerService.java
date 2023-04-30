package com.clubmanagement.app.service.player;

import com.clubmanagement.app.repository.player.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAll();
    Player findById(Long id);
    Player save(Player thePlayer);
    void deleteById(Long id);
}
