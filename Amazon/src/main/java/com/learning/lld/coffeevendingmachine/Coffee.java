package com.learning.lld.coffeevendingmachine;

import lombok.Getter;

import java.util.Map;

@Getter
public class Coffee {
    private CoffeeType coffeeType;
    private double price;
    private Map<Ingredient, Integer> recipe;

    public Coffee(CoffeeType coffeeType, double price, Map<Ingredient, Integer> recipe) {
        this.coffeeType = coffeeType;
        this.price = price;
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "COFFEE: " + coffeeType + ", PRICE: ($) " + price;
    }
}
