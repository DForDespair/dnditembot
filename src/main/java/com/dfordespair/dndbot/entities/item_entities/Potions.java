package com.dfordespair.dndbot.entities.item_entities;

import com.dfordespair.dndbot.entities.store_entities.StoreInventory;
import com.dfordespair.dndbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.Entity;

import java.util.Set;

@Entity
public class Potions extends Item{

    public Potions( String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super( name, description, isMagic, weight, storeInventoryItems);
    }

    public Potions(String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, isMagic, weight, storeInventoryItems);
    }

    public Potions( String name, String description, boolean isMagic, double weight) {
        super( name, description, isMagic, weight);
    }

    public Potions(String name, boolean isMagic, double weight) {
        super( name, isMagic, weight);
    }

    public Potions() {
        super();
    }

    @Override
    public String toString() {
        return "Potions{} " + super.toString();
    }
}
