package com.learning.lld.pizzaprice;

public enum Size {
    S(5.0), M(10.0), L(20.0);


    private double basePrice;
    Size(double value) {
        this.basePrice = value;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
