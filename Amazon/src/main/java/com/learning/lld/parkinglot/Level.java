package com.learning.lld.parkinglot;

import com.learning.lld.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floorNumber, int numberOfSpots) {
        this.floorNumber = floorNumber;


        this.parkingSpots = new ArrayList<>(numberOfSpots);
        //fill the parking sport here or elsewhere.
    }

    public synchronized boolean park(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            try {
                parkingSpot.park(vehicle);
                return true;
            } catch (Exception e) {}
        }

        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getVehicle().equals(vehicle)) {
                parkingSpot.unpark();
                return true;
            }
        }

        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floorNumber + ": Available spots: "  );
        for (ParkingSpot parkingSpot : parkingSpots) {
            System.out.println("Spot: " + parkingSpot.getId() + ": " + (parkingSpot.isOccupied() ? "Occupied" : "Unoccupied"));
        }
    }
}
