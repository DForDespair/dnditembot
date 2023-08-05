package com.dfordespair.dndbot.entities.item_entities;

import com.dfordespair.dndbot.entities.store_entities.StoreInventory;
import com.dfordespair.dndbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "gear")
public class Gear extends Item {
    public Gear( String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super( name, description, isMagic, weight, storeInventoryItems);
    }

    public Gear( String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems) {
        super(name, isMagic, weight, storeInventoryItems);
    }

    public Gear( String name, String description, boolean isMagic, double weight) {
        super(name, description, isMagic, weight);
    }

    public Gear( String name, boolean isMagic, double weight) {
        super(name, isMagic, weight);
    }

    public Gear() {
        super();
    }

    @Override
    public String toString() {
        return "Gear{} " + super.toString();
    }
}
