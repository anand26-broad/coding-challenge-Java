package com.hexaware.challenge.service;

import com.hexaware.challenge.dto.PlayerRequestDTO;
import com.hexaware.challenge.dto.PlayerResponseDTO;
import com.hexaware.challenge.entity.Player;
import com.hexaware.challenge.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    // Fetch all players and convert to ResponseDTO
    public List<PlayerResponseDTO> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(player -> new PlayerResponseDTO(
                        player.getPlayerId(),
                        player.getPlayerId(),
                        player.getJerseyNumber(),
                        player.getRole()
                ))
                .collect(Collectors.toList());
    }

    // Fetch player by ID and convert to ResponseDTO
    public PlayerResponseDTO getPlayerById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow();
        return new PlayerResponseDTO(player.getPlayerId(), player.getPlayerId(), player.getJerseyNumber(), player.getRole());
    }

    // Save a new player using RequestDTO
    public PlayerResponseDTO savePlayer(PlayerRequestDTO playerRequestDTO) {
        Player player = new Player();
        player.setPlayerId(playerRequestDTO.getPlayerName());
        player.setJerseyNumber(playerRequestDTO.getJerseyNumber());
        player.setRole(playerRequestDTO.getRole());
        player.setTotalMatches(playerRequestDTO.getTotalMatches());
        player.setTeamName(playerRequestDTO.getTeamName());
        player.setCountryStateName(playerRequestDTO.getCountryStateName());
        player.setDescription(playerRequestDTO.getDescription());

        Player savedPlayer = playerRepository.save(player);
        return new PlayerResponseDTO(savedPlayer.getPlayerId(), savedPlayer.getPlayerId(), savedPlayer.getJerseyNumber(), savedPlayer.getRole());
    }

    // Update player using RequestDTO
    public PlayerResponseDTO updatePlayer(Long id, PlayerRequestDTO playerRequestDTO) {
        Player player = playerRepository.findById(id)
                .orElseThrow();

        player.setPlayerId(playerRequestDTO.getPlayerName());
        player.setJerseyNumber(playerRequestDTO.getJerseyNumber());
        player.setRole(playerRequestDTO.getRole());
        player.setTotalMatches(playerRequestDTO.getTotalMatches());
        player.setTeamName(playerRequestDTO.getTeamName());
        player.setCountryStateName(playerRequestDTO.getCountryStateName());
        player.setDescription(playerRequestDTO.getDescription());

        Player updatedPlayer = playerRepository.save(player);
        return new PlayerResponseDTO(updatedPlayer.getPlayerId(), updatedPlayer.getPlayerId(), updatedPlayer.getJerseyNumber(), updatedPlayer.getRole());
    }
}
