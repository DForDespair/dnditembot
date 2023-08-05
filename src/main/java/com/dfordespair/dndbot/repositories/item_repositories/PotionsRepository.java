package com.dfordespair.dndbot.repositories.item_repositories;

import com.dfordespair.dndbot.entities.item_entities.Potions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PotionsRepository extends JpaRepository<Potions, Long> {
}