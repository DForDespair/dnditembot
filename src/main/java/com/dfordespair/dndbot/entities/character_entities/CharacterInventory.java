package com.dfordespair.dndbot.entities.character_entities;

import com.dfordespair.dndbot.entities.item_entities.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CharacterInventory {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO)
    public Long id;

    @OneToMany(
            mappedBy = "inventory"
    )
    public Set<CharacterInventoryItem> items = new HashSet<>();

    @OneToOne
    public PlayerCharacter character;

    public CharacterInventory(Set<CharacterInventoryItem> items, PlayerCharacter character) {
        this.items = items;
        this.character = character;
    }

    public CharacterInventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CharacterInventoryItem> getItems() {
        return items;
    }

    public void setItems(Set<CharacterInventoryItem> items) {
        this.items = items;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }

    public void addInventoryItem(Item item, Integer quantity){
        CharacterInventoryItem itemToAdd = new CharacterInventoryItem();
        itemToAdd.setItem(item);
        itemToAdd.setQuantity(quantity);
        itemToAdd.setInventory(this);
        items.add(itemToAdd);
    }

    @Override
    public String toString() {
        return "CharacterInventory{" +
                "id=" + id +
                ", items=" + items +
                ", character=" + character +
                '}';
    }
}
