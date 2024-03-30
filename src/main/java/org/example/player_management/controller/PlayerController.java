package org.example.player_management.controller;

import org.example.player_management.model.Player;
import org.example.player_management.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PlayerController {

    private final IPlayerService IPlayerService;

    @Autowired
    public PlayerController(IPlayerService IPlayerService){
        this.IPlayerService = IPlayerService;
    }

    @PostMapping("/create")
    public Player createPlayer(@RequestBody Player player) {
        return IPlayerService.createPlayer(player);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return IPlayerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return IPlayerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        IPlayerService.deletePlayer(id);
    }
}