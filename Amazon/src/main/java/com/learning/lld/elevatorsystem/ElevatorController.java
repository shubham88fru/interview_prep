package com.learning.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(int numberOfElevators, int capacity) {
        this.elevators = new ArrayList<Elevator>();
        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(i+1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator elevator = findOptimalElevator(sourceFloor, destinationFloor);
        Request request = new Request(sourceFloor, destinationFloor);
        System.out.println("Request queued: " + request);

        elevator.addRequest(request);
    }

    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            if (distance < minDistance) {
                optimalElevator = elevator;
                minDistance = distance;
            }
        }

        System.out.println(
                "Optimal elevator: " + optimalElevator.getId()
        );
        return optimalElevator;
    }
}
