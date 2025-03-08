package com.learning.lld.parkinglot;

import com.learning.lld.parkinglot.vehicle.Bike;
import com.learning.lld.parkinglot.vehicle.Car;
import com.learning.lld.parkinglot.vehicle.Truck;
import com.learning.lld.parkinglot.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 100));
        parkingLot.addLevel(new Level(2, 50));

        Vehicle car = new Car("Car A");
        Vehicle bike = new Bike("Bike A");
        Vehicle truck = new Truck("Truck A");

        parkingLot.park(car);
        parkingLot.park(bike);
        parkingLot.park(truck);

        parkingLot.displayAvailability();

        parkingLot.unpark(car);
        parkingLot.displayAvailability();

    }
}
