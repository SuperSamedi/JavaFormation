package com.digitalcity.advanced.threads.vehiclefactory;

public class Engine {
    private final int power;


    public Engine (int power) {
        this.power = power;
    }


    public int getPower() {
        return power;
    }

    @Override

    public String toString() {
        String display = "Engine - " + "Power : " + power;
        if(power > 9000)
            display += " - Its power is over 9000!";
        return display;
    }
}
