package com.digitalcity.advanced.threads.vehiclefactory;

public class Vehicle {
    private Frame frame;
    private WheelSet wheelSet;
    private Engine engine;

    public Vehicle(Frame frame, WheelSet wheelSet, Engine engine){
        this.frame = frame;
        this.wheelSet = wheelSet;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "\nVehicle{\n" + frame + "\n" + wheelSet + "\n" + engine + "\n}";
    }
}
