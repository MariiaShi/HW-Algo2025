package org.hw2;

import java.util.Arrays;
import java.util.Comparator;

public class ElevatorApp {
    public static void main(String[] args) {
        Elevator[] elevators = new Elevator[]{
                new Elevator(3, 4, "A"),
                new Elevator(2, 8, "B"),
                new Elevator(2, 5, "C")
        };
        System.out.println(callElevator(1, elevators));
    }

    public static Elevator callElevator(int targetFloor, Elevator[] elevators) {
        Arrays.sort(elevators, Comparator.comparingDouble((Elevator e) -> e.timeToReach(targetFloor))
                .thenComparing(e -> e.difference(targetFloor)));
        return elevators[0];
    }
}
