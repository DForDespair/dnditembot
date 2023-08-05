package com.dfordespair.dndbot.repositories.character_repositories;

import com.dfordespair.dndbot.entities.character_entities.DiscordAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscordAccountRepository extends JpaRepository<DiscordAccount, Long> {
}