package com.hexaware.challenge.controller;

import com.hexaware.challenge.dto.PlayerRequestDTO;
import com.hexaware.challenge.dto.PlayerResponseDTO;
import com.hexaware.challenge.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Fetch all players
    @GetMapping
    public List<PlayerResponseDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Fetch a specific player by ID
    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    // Create a new player
    @PostMapping
    public ResponseEntity<PlayerResponseDTO> createPlayer(@Valid @RequestBody PlayerRequestDTO playerRequestDTO) {
        return ResponseEntity.ok(playerService.savePlayer(playerRequestDTO));
    }

    // Update an existing player
    @PutMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> updatePlayer(
            @PathVariable Long id,
            @Valid @RequestBody PlayerRequestDTO playerRequestDTO) {
        return ResponseEntity.ok(playerService.updatePlayer(id, playerRequestDTO));
    }

    // Delete a player
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable PlayerRequestDTO id) {
        playerService.savePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
