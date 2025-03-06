package com.learning.lld.coffeevendingmachine;

import lombok.Getter;

@Getter
public class Ingredient {
    private String name;
    private int quantity;
    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
