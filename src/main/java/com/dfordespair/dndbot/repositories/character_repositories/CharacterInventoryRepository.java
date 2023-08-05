package com.dfordespair.dndbot.repositories.character_repositories;

import com.dfordespair.dndbot.entities.character_entities.CharacterInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryRepository extends JpaRepository<CharacterInventory, Long> {
}