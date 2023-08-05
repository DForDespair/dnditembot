package com.dfordespair.dndbot.repositories.store_repositories;

import com.dfordespair.dndbot.entities.store_entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}