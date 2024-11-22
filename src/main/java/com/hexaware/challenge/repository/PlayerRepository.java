package com.hexaware.challenge.repository;
import com.hexaware.challenge.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // JpaRepository provides basic CRUD operations by default
    // Additional custom query methods can be added here if needed
}