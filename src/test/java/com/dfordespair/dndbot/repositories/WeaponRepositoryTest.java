package com.dfordespair.dndbot.repositories;

import com.dfordespair.dndbot.entities.item_entities.DamageType;
import com.dfordespair.dndbot.entities.item_entities.Item;
import com.dfordespair.dndbot.entities.item_entities.Properties;
import com.dfordespair.dndbot.entities.item_entities.Weapon;
import com.dfordespair.dndbot.repositories.item_repositories.WeaponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WeaponRepositoryTest {
    @Autowired
    private WeaponRepository underTest;

    @Test
    void itShouldSelectWeaponByDamageType() {
        //Given
        Set<Properties> propertiesSet = new HashSet<>();
        propertiesSet.add(Properties.RANGE);
        propertiesSet.add(Properties.AMMUNITION);
        Weapon dragonThrowingAxe = new Weapon("Dragon Throwing Axe", false, 1, DamageType.ACID, propertiesSet);
        //When
        underTest.save(dragonThrowingAxe);
        //Then
        Optional<Weapon> optionalWeapon = underTest.filterByDamageType(DamageType.ACID);
        assertThat(optionalWeapon)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).usingRecursiveComparison().isEqualTo(dragonThrowingAxe);
                });
    }

    @Test
    void itShouldSelectAllWeaponsByProperty() {
        //Given
        Set<Properties> propertiesSet = new HashSet<>();
        propertiesSet.add(Properties.RANGE);
        propertiesSet.add(Properties.AMMUNITION);
        Weapon dragonThrowingAxe = new Weapon("Dragon Throwing Axe", false, 1, DamageType.ACID, propertiesSet);
        //When
        underTest.save(dragonThrowingAxe);
        Optional<Weapon> optionalWeapon = underTest.filterByProperty(Properties.RANGE);
        System.out.println(optionalWeapon.orElseGet(null));
        //Then
        assertThat(optionalWeapon)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).usingRecursiveComparison().isEqualTo(dragonThrowingAxe);
                });

    }

    @Test
    void itShouldSelectByName() {
        //Given
        Set<Properties> propertiesSet = new HashSet<>();
        propertiesSet.add(Properties.RANGE);
        propertiesSet.add(Properties.AMMUNITION);
        Weapon dragonThrowingAxe = new Weapon("Dragon Throwing Axe", false, 1, DamageType.ACID, propertiesSet);
        //When
        underTest.save(dragonThrowingAxe);
        Optional<Item> optionalWeapon = underTest.searchByKeyword("Dragon");
        System.out.println(optionalWeapon.get());
        //Then
        assertThat(optionalWeapon)
                .isPresent()
                .hasValueSatisfying(c -> {
                    assertThat(c).usingRecursiveComparison().isEqualTo(dragonThrowingAxe);
                });
    }
}