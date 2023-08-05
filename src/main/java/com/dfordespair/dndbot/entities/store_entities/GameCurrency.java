package com.dfordespair.dndbot.entities.store_entities;

import com.dfordespair.dndbot.exceptions.ConversionException;


public enum GameCurrency {
    GOLD(100),
    SILVER(10),
    COPPER(1);

    private final int factor;

    GameCurrency(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }

    public int convert(int amount, GameCurrency targetCurrency) throws ConversionException {
        int result = amount * this.factor / targetCurrency.factor;
        if (result * targetCurrency.factor != amount * this.factor) {
            throw new ConversionException("Conversion would result in a fractional amount");
        }
        return result;
    }
}
