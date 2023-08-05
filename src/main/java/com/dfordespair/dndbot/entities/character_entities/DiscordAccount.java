package com.dfordespair.dndbot.entities.character_entities;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class DiscordAccount {
    @Id
    public Long id;

    @Column
    public String username;

    @Column
    public String discriminator;

    @OneToMany(
            mappedBy = "discordAccount"
    )
    public Set<PlayerCharacter> playerCharactersSet = new HashSet<>();

    public DiscordAccount(String username, String discriminator, Set<PlayerCharacter> playerCharactersSet) {
        this.username = username;
        this.discriminator = discriminator;
        this.playerCharactersSet = playerCharactersSet;
    }

    public DiscordAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public Set<PlayerCharacter> getPlayerCharactersSet() {
        return playerCharactersSet;
    }

    public void setPlayerCharactersSet(Set<PlayerCharacter> playerCharactersSet) {
        this.playerCharactersSet = playerCharactersSet;
    }

    public void addPlayerCharacter(String firstName, String lastName, String characterClass, BigInteger xp){
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setLastName(lastName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setXp(xp);
        playerCharacterToAdd.setDiscordAccount(this);
        playerCharactersSet.add(playerCharacterToAdd);
    }
    public void addPlayerCharacter(String firstName, String characterClass, BigInteger xp){
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setXp(xp);
        playerCharacterToAdd.setDiscordAccount(this);
        playerCharactersSet.add(playerCharacterToAdd);
    }
    public void addPlayerCharacter(String firstName, String characterClass){
        PlayerCharacter playerCharacterToAdd = new PlayerCharacter();
        playerCharacterToAdd.setFirstName(firstName);
        playerCharacterToAdd.setCharacterClass(characterClass);
        playerCharacterToAdd.setDiscordAccount(this);
        playerCharactersSet.add(playerCharacterToAdd);
    }

    @Override
    public String toString() {
        return "DiscordAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", discriminator='" + discriminator + '\'' +
                ", playerCharactersSet=" + playerCharactersSet +
                '}';
    }
}
