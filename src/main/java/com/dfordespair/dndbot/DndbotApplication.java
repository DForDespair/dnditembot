package com.dfordespair.dndbot;

import com.dfordespair.dndbot.entities.item_entities.DamageType;
import com.dfordespair.dndbot.entities.item_entities.Properties;
import com.dfordespair.dndbot.entities.item_entities.Weapon;
import com.dfordespair.dndbot.repositories.item_repositories.WeaponRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DndbotApplication {

    public static void main(String[] args) {

        SpringApplication.run(DndbotApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner (WeaponRepository weaponRepository){
        return args -> {
            Set<Properties> propertiesSet = new HashSet<>();
            propertiesSet.add(Properties.TWO_HANDED);
            Weapon weapon = new Weapon("Holy Weapon",true,10, DamageType.SLASHING, propertiesSet);
            weaponRepository.save(weapon);
        };
    }

}
