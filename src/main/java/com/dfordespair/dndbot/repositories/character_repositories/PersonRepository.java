package com.dfordespair.dndbot.repositories.character_repositories;

import com.dfordespair.dndbot.entities.character_entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}