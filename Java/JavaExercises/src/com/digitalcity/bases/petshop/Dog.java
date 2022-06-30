package com.digitalcity.bases.petshop;


import com.digitalcity.bases.petshop.enums.CollarColor;
import com.digitalcity.bases.petshop.enums.DogBreed;

import java.time.LocalDate;

public class Dog extends Animal {
    private CollarColor collar;
    private boolean isTrained;
    private DogBreed breed;

    public Dog(String name, Sex sex, float weight, float height, LocalDate dateOfBirth, LocalDate arrivingDate, CollarColor collar, boolean istrained, DogBreed breed){
        super(name, sex, weight, height, dateOfBirth, arrivingDate);
        this.collar = collar;
        this.isTrained = istrained;
        this.breed = breed;
        this.setHumanAgeEquivalenceMultiplier(7);
        this.setDeathRate(0.01f);
    }

    //#region Getters and Setters
    public CollarColor getCollar() {
        return collar;
    }

    public void setCollar(CollarColor collar) {
        this.collar = collar;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setIsTrained(boolean trained) {
        isTrained = trained;
    }

    public DogBreed getBreed() {
        return breed;
    }

    public void setBreed(DogBreed breed) {
        this.breed = breed;
    }
    //#endregion

    @Override
    public void cry() {
        System.out.println("Woof!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name: " + this.getName() +
                ", sex: " + getSex() +
                ", age: " + getAge() +
                ", human age equivalent: " + this.getHumanAgeEquivalence() +
                ", breed: " + this.getBreed() +
                ", weight: " + this.getWeight() + "kg" +
                ", height: " + this.getHeight() + "m" +
                ", is trained: " + this.isTrained() +
                ", collar color: " + this.getCollar() +
                ", arrived on: " + this.getArrivingDate() +
                '}';
    }
}
