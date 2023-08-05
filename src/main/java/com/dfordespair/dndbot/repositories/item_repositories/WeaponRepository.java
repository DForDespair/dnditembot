package com.dfordespair.dndbot.repositories.item_repositories;

import com.dfordespair.dndbot.entities.item_entities.DamageType;
import com.dfordespair.dndbot.entities.item_entities.Properties;
import com.dfordespair.dndbot.entities.item_entities.Weapon;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WeaponRepository extends ItemRepository {


    @Query("SELECT w FROM Weapon w WHERE w.damageType = :damageType")
    Optional<Weapon> filterByDamageType(DamageType damageType);

    @Query("SELECT w FROM Weapon w WHERE :property MEMBER OF w.property")
    Optional<Weapon> filterByProperty(Properties property);

    @Query("SELECT w FROM Weapon w WHERE w.damageType = :damageType AND w.isMagic = :isMagic")
    Optional<Weapon> filterByDamageTypeAndMagic(DamageType damageType, boolean isMagic);


}
