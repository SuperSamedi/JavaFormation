package com.digitalcity.bases.petshop;

import com.digitalcity.bases.petshop.enums.BirdColor;

import java.time.LocalDate;

public class Bird extends Animal {
    private BirdColor color;
    private boolean islivingInAviary;


    public Bird(String name, Sex sex, float weight, float height, LocalDate dateOfBirth, LocalDate arrivingDate, BirdColor color, boolean islivingInAviary) {
        super(name, sex, weight, height, dateOfBirth, arrivingDate);
        this.color = color;
        this.islivingInAviary = islivingInAviary;
        this.setHumanAgeEquivalenceMultiplier(10);
        this.setDeathRate(0.03f);
    }

    //#region Getters and Setters
    public BirdColor getColor() {
        return color;
    }

    public void setColor(BirdColor color) {
        this.color = color;
    }

    public boolean getIsLivingInAviary(){
        return islivingInAviary;
    }

    public void setIslivingInAviary(boolean islivingInAviary) {
        this.islivingInAviary = islivingInAviary;
    }
    //#endregion

    @Override
    public void cry() {
        System.out.println("Tweetwee!");
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name: " + this.getName() +
                ", sex: " + this.getSex() +
                ", color: " + this.getColor() +
                ", age: " + this.getAge() +
                ", human age equivalent: " + this.getHumanAgeEquivalence() +
                ", weight: " + this.getWeight() + "kg" +
                ", height: " + this.getHeight() + "m" +
                ", must live in an aviary: " + this.getIsLivingInAviary() +
                ", arrived on: " + this.getArrivingDate() +
                '}';
    }
}
