package com.learning.lld.pizzaprice;

import java.util.HashMap;
import java.util.Map;

public class Pizza {
    private double basePrice;
//    private Size size;
    private Map<ITopping, Integer> toppings;

    public Pizza(Size size) {
        this.basePrice = size.getBasePrice();
//        this.size = size;
        this.toppings = new HashMap<>();
    }

    public void addTopping(ITopping topping) {
        this.toppings.put(topping, this.toppings.getOrDefault(topping, 0) + 1);
        this.basePrice += topping.getPrice();
    }

    public void removeTopping(ITopping topping) {
        if (!this.toppings.containsKey(topping)) return;

        this.toppings.put(topping, this.toppings.get(topping) - 1);
        if (this.toppings.get(topping) == 0) this.toppings.remove(topping);

        this.basePrice -= topping.getPrice();
    }

    public double getPrice() {
        return this.basePrice;
    }
}
