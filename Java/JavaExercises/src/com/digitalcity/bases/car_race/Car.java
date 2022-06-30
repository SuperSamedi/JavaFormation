package com.digitalcity.bases.car_race;

import java.util.Random;

public class Car {
    //#region Attributes
    private Random rng;
    private String constructor;
    private String model;
    private float speedMin; //km/h
    private float speedMax; //km/h
    //#endregion

    //#region Contructors
    public Car(String constructor, String model, int speedMin, int speedMax) {
        this.constructor = constructor;
        this.model = model;
        this.speedMin = speedMin;
        this.speedMax = speedMax;
        this.rng = new Random();
    }
    //#endregion

    //#region Getters and Setters
    public String getConstructor() { return constructor; }
    public String getModel() { return model; }
    public float getSpeedMin() { return speedMin; }
    public void setSpeedMin(int speedMin) { this.speedMin = speedMin; }
    public float getSpeedMax() { return speedMax; }
    public void setSpeedMax(int speedMax) { this.speedMax = speedMax; }
    //#endregion

    //Speed in km/s
    public float getSpeed() {
        float randomSpeed = rng.nextFloat(speedMin, speedMax + 1);
        randomSpeed /= 3600;
        return randomSpeed;
    }

    @Override
    public String toString() {
        return "Car{" + model + " by " + constructor + "}";
    }
}
