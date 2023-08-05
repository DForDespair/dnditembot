package com.dfordespair.dndbot.entities.store_entities;

import com.dfordespair.dndbot.entities.item_entities.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class StoreInventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_inventory_id",
    nullable = false)
    private StoreInventory storeInventory;

    @ManyToOne
    @JoinColumn(name = "item_id",
    nullable = false)
    private Item item;

    @Column
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,
        name = "currency")
    private GameCurrency gameCurrency;

    public StoreInventoryItem() {
    }

    public StoreInventoryItem(StoreInventory storeInventory, Item item, int price, GameCurrency gameCurrency) {
        this.storeInventory = storeInventory;
        this.item = item;
        this.price = price;
        this.gameCurrency = gameCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreInventory getStoreInventory() {
        return storeInventory;
    }

    public void setStoreInventory(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public GameCurrency getGameCurrency() {
        return gameCurrency;
    }

    public void setGameCurrency(GameCurrency gameCurrency) {
        this.gameCurrency = gameCurrency;
    }

    @Override
    public String toString() {
        return "StoreInventoryItem{" +
                "id=" + id +
                ", storeInventory=" + storeInventory +
                ", item=" + item +
                ", price=" + price +
                ", gameCurrency=" + gameCurrency +
                '}';
    }
}
