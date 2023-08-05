package com.dfordespair.dndbot.entities.store_entities;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String city;


    @OneToOne(mappedBy = "stores", cascade = CascadeType.ALL)
    private StoreInventory storeInventory;

    public Store(String name, String city, StoreInventory storeInventory) {
        this.name = name;
        this.city = city;
        this.storeInventory = storeInventory;
    }

    public Store() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public StoreInventory getStoreInventory() {
        return storeInventory;
    }

    public void setStoreInventory(StoreInventory storeInventory) {
        this.storeInventory = storeInventory;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", storeInventory=" + storeInventory +
                '}';
    }
}
