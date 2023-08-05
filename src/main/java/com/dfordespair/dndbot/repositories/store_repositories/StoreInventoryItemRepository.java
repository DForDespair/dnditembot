package com.dfordespair.dndbot.repositories.store_repositories;

import com.dfordespair.dndbot.entities.store_entities.StoreInventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreInventoryItemRepository extends JpaRepository<StoreInventoryItem, Long> {
}