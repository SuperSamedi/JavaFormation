package com.digitalcity.advanced.threads.vehiclefactory;

public class WheelSet {
    private Wheel[] wheels;


    public WheelSet(){
        this.wheels = new Wheel[4];
    }


    public double getDiameter() {
        if (wheels[0] != null)
            return wheels[0].getDiameter();

        return 0;
    }

    public void addWheel(int index, Wheel wheel){
        this.wheels[index] = wheel;
    }

    @Override
    public String toString() {
        return "Wheel set - " + "diameter : " + (String.format("%,.1f", getDiameter()));
    }
}
