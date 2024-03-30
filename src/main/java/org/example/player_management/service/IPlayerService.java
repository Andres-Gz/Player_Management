package org.example.player_management.service;

import org.example.player_management.model.Player;

public interface IPlayerService {
    Player createPlayer(Player player);

    Player getPlayerById(Long id);

    Player updatePlayer(Long id, Player player);

    void deletePlayer(Long id);
}
