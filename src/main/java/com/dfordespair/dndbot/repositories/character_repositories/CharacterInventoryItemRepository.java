package com.dfordespair.dndbot.repositories.character_repositories;

import com.dfordespair.dndbot.entities.character_entities.CharacterInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterInventoryItemRepository extends JpaRepository<CharacterInventoryItem, Long> {
}