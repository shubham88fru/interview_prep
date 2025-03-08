package com.learning.lld.parkinglot;

import com.learning.lld.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot() {
        this.levels = new ArrayList<>();
        //initialize the levels here.
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }

    public boolean park(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.park(vehicle)) {
                return true;
            }
        }

        System.out.println("Could not park vehicle " + vehicle);
        return false;
    }

    public boolean unpark(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unpark(vehicle)) {
                return true;
            }
        }

        return false;
    }


    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
