package com.dfordespair.dndbot.entities.store_entities;

import com.dfordespair.dndbot.entities.item_entities.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "store_inventory")
public class StoreInventory {

    @Id
    @GeneratedValue(strategy =  GenerationType.TABLE)
    private Long id;

   @OneToOne
   @JoinColumn(name = "store_id")
    private Store stores;

    @OneToMany(mappedBy = "storeInventory")
    private Set<StoreInventoryItem> storeInventoryItems = new HashSet<>();

    public StoreInventory(Store stores, Set<StoreInventoryItem> storeInventoryItems) {
        this.stores = stores;
        this.storeInventoryItems = storeInventoryItems;
    }

    public StoreInventory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store getStores() {
        return stores;
    }

    public void setStores(Store stores) {
        this.stores = stores;
    }

    public Set<StoreInventoryItem> getStoreInventoryItems() {
        return storeInventoryItems;
    }

    public void setStoreInventoryItems(Set<StoreInventoryItem> storeInventoryItems) {
        this.storeInventoryItems = storeInventoryItems;
    }

    public void addStoreInventoryItem(Item item, int price, GameCurrency currency){
        StoreInventoryItem storeInventoryItemToAdd = new StoreInventoryItem();
        storeInventoryItemToAdd.setItem(item);
        storeInventoryItemToAdd.setPrice(price);
        storeInventoryItemToAdd.setGameCurrency(currency);
        storeInventoryItems.add(storeInventoryItemToAdd);
    }

    @Override
    public String toString() {
        return "StoreInventory{" +
                "id=" + id +
                ", stores=" + stores +
                ", storeInventoryItems=" + storeInventoryItems +
                '}';
    }
}
