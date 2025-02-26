package org.hw2;

public class Elevator {
    private int speed;
    private int floor;
    private String name;

    public Elevator(int speed, int floor, String name) {
        this.speed = speed;
        this.floor = floor;
        this.name = name;
    }

    public double difference(int targetFloor){
        return Math.abs(targetFloor - floor);
    }
    public double timeToReach(int targetFloor){
        return difference(targetFloor) * speed;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "speed=" + speed +
                ", floor=" + floor +
                ", name='" + name + '\'' +
                '}';
    }
}
