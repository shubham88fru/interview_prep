package com.learning.lld.parkinglot;

import com.learning.lld.parkinglot.vehicle.Vehicle;
import com.learning.lld.parkinglot.vehicle.VehicleType;
import lombok.Getter;

public class ParkingSpot {
    @Getter
    private final int id;
    @Getter
    private final VehicleType type;
    @Getter
    private Vehicle vehicle;

    public ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public synchronized boolean isOccupied() {
        return vehicle != null;
    }

    public synchronized void park(Vehicle vehicle) {
        if (isOccupied()) {
            throw new IllegalStateException("Spot is occupied");
        }

        if (vehicle.getVehicleType() != type) {
            throw new IllegalStateException("Vehicle " + vehicle.getVehicleType() + " cant be parked at " + type);
        }

        this.vehicle = vehicle;
    }

    public synchronized void unpark() {
        this.vehicle = null;
    }

}
