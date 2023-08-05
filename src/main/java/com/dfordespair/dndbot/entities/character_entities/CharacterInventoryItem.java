package com.dfordespair.dndbot.entities.character_entities;

import com.dfordespair.dndbot.entities.item_entities.Item;
import com.dfordespair.dndbot.entities.store_entities.StoreInventory;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CharacterInventoryItem {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "inventory_id",
            nullable = false
    )
    private CharacterInventory inventory;

    @ManyToOne
    @JoinColumn(name = "item_id",
    nullable = false)
    private Item item;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    public CharacterInventoryItem(CharacterInventory inventory, Item item, Integer quantity) {
        this.inventory = inventory;
        this.item = item;
        this.quantity = quantity;
    }

    public CharacterInventoryItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CharacterInventory getInventory() {
        return inventory;
    }

    public void setInventory(CharacterInventory inventory) {
        this.inventory = inventory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CharacterInventoryItem{" +
                "id=" + id +
                ", inventory=" + inventory +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
