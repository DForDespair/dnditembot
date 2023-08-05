package com.dfordespair.dndbot.repositories.store_repositories;

import com.dfordespair.dndbot.entities.store_entities.StoreInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long> {
}