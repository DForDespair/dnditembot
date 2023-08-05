package com.dfordespair.dndbot.repositories.item_repositories;

import com.dfordespair.dndbot.entities.item_entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);

    Optional<Item> findByDescriptionContaining(String keyword);

    @Query("select i from Item i where i.isMagic = :isMagic")
    Optional<Item> findByIsMagic(boolean isMagic);

    Optional<Item> findByWeightLessThan(double weight);


    @Query("SELECT i FROM Item i WHERE i.name LIKE %:keyword%")
    Optional<Item> searchByKeyword(String keyword);

    @Query("SELECT i FROM Item i WHERE i.isMagic = :isMagic")
    Optional<Item> filterByMagicProperty(boolean isMagic);

    @Query("SELECT i FROM Item i WHERE i.weight BETWEEN :weight1 AND :weight2")
    Optional<Item> findByWeightRange(double weight1, double weight2);

    @Query("SELECT i FROM Item i ORDER BY i.weight DESC")
    Optional<Item> sortByWeightDesc();

}
