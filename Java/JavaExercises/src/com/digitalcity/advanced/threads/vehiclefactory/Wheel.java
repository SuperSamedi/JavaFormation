package com.digitalcity.advanced.threads.vehiclefactory;

public class Wheel {
    private double diameter;

    public Wheel(double diameter) {
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }



    @Override
    public String toString() {
        return "Wheel - " + "diameter : " + diameter;
    }
}
