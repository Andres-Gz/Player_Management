package org.example.player_management.service;

import org.example.player_management.model.Player;
import org.example.player_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlayerServiceImpl implements IPlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(Long id) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        return optionalPlayer.orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(Long id, Player player) {
        Optional<Player> optionalPlayer = playerRepository.findById(id);
        if (optionalPlayer.isPresent()) {
            Player existingPlayer = optionalPlayer.get();
            existingPlayer.setName(player.getName());
            // Set other fields as needed
            return playerRepository.save(existingPlayer);
        }
        return null;
    }

    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}