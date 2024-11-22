package com.hexaware.challenge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity // Marks this class as a JPA Entity
public class Player {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private String playerId; // Change type to Long for auto-generated IDs

    @NotNull(message = "Player name is required.") // Validation for non-null values
    private String playerName;

    @NotNull(message = "Jersey number is required.")
    private Integer jerseyNumber;

    @NotNull(message = "Role is required.") // E.g., Batsman, Bowler, Keeper
    private String role;

    private Integer totalMatches; // Total matches played by the player
    private String teamName; // Name of the team
    private String countryStateName; // Country or state of the team
    private String description; // Brief description of the player

    // Default constructor
    public Player() {
    }

    // Constructor with fields
    public Player(String playerName, Integer jerseyNumber, String role, Integer totalMatches,
                  String teamName, String countryStateName, String description) {
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryStateName = countryStateName;
        this.description = description;
    }

    // Constructor with playerId (though typically, the ID is auto-generated and not passed during object creation)
    public Player(String playerId, String playerName, Integer jerseyNumber, String role, 
                  Integer totalMatches, String teamName, String countryStateName, String description) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
        this.totalMatches = totalMatches;
        this.teamName = teamName;
        this.countryStateName = countryStateName;
        this.description = description;
    }

    // Getters and Setters
    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryStateName() {
        return countryStateName;
    }

    public void setCountryStateName(String countryStateName) {
        this.countryStateName = countryStateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


