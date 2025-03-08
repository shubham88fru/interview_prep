package com.learning.lld.parkinglot.vehicle;

import lombok.Getter;

@Getter
public abstract class Vehicle {
    private String number;
    private VehicleType vehicleType;

    public Vehicle(String number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }
}
