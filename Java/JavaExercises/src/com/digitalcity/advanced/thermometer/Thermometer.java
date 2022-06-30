package com.digitalcity.advanced.thermometer;

public class Thermometer {
    private int temperature;
    private int previousTemperature;

    private TemperatureListener actionTempUp;
    private TemperatureListener actionTempDown;

    public Thermometer(int temperature) {
        this.temperature = temperature;
        this.previousTemperature = temperature;
    }

    public void setTemperature(int newTemperature) {
        previousTemperature = this.temperature;
        this.temperature = newTemperature;

        if (newTemperature > previousTemperature && actionTempUp != null) {
            actionTempUp.reaction(temperatureDelta(), newTemperature);
        }
        if (newTemperature < previousTemperature && actionTempDown != null) {
            actionTempDown.reaction(temperatureDelta(), newTemperature);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void subTemperatureUp(TemperatureListener action) {
        actionTempUp = action;
    }

    public void subTemperatureDown(TemperatureListener action) {
        actionTempDown = action;
    }

    private int temperatureDelta() {
        return Math.abs(previousTemperature - getTemperature());
    }
}