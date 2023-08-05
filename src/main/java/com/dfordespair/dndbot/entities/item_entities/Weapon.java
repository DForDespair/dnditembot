package com.dfordespair.dndbot.entities.item_entities;

import com.dfordespair.dndbot.entities.store_entities.StoreInventory;
import com.dfordespair.dndbot.entities.store_entities.StoreInventoryItem;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "weapon")
@PrimaryKeyJoinColumn(name = "item_id")
public class Weapon extends Item  {

    @Enumerated(EnumType.STRING)
    @Column(name = "damage_type")
    private DamageType damageType;

    @ElementCollection(targetClass = Properties.class)
    @CollectionTable(name = "weapon_properties",
            joinColumns = @JoinColumn(
                    name = "weapon_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "property")
    private Set<Properties> property;


    public Weapon(String name, String description, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, DamageType damageType, Set<Properties> property) {
        super( name, description, isMagic, weight, storeInventoryItems);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon( String name, boolean isMagic, double weight, Set<StoreInventoryItem> storeInventoryItems, DamageType damageType, Set<Properties> property) {
        super(name, isMagic, weight, storeInventoryItems);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon(String name, String description, boolean isMagic, double weight, DamageType damageType, Set<Properties> property) {
        super(name, description, isMagic, weight);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon(String name, boolean isMagic, double weight, DamageType damageType, Set<Properties> property) {
        super(name, isMagic, weight);
        this.damageType = damageType;
        this.property = property;
    }

    public Weapon() {
        super();
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Set<Properties> getProperty() {
        return property;
    }

    public void setProperty(Set<Properties> property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "Weapon {\n" +
                "    id=" + getId() + ",\n" +
                "    name='" + getName() + "',\n" +
                "    description='" + getDescription() + "',\n" +
                "    isMagic=" + isMagic() + ",\n" +
                "    weight=" + getWeight() + ",\n" +
                "    damageType=" + damageType + ",\n" +
                "    property=" + property + "\n" +
                "}";
    }
}
