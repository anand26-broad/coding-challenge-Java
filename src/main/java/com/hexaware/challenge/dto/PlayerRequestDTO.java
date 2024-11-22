package com.hexaware.challenge.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PlayerRequestDTO {

    @NotNull(message = "Player name is required.")
    @Size(min = 3, max = 50, message = "Player name must be between 3 and 50 characters.")
    private String playerName;

    @NotNull(message = "Jersey number is required.")
    private Integer jerseyNumber;

    @NotNull(message = "Role is required.")
    private String role;

    private Integer totalMatches;
    private String teamName;
    private String countryStateName;
    private String description;

    // Getters and setters
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
