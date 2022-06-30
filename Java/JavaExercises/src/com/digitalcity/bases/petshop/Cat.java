package com.digitalcity.bases.petshop;

import com.digitalcity.bases.petshop.enums.CatCharacter;


import java.time.LocalDate;

public class Cat extends Animal {
    private CatCharacter character;
    private boolean isClawsTrimmed;
    private boolean isLongHair;


    public Cat(String name, Sex sex, float weight, float height, LocalDate dateOfBirth, LocalDate arrivingDate, CatCharacter character, boolean isClawsTrimmed, boolean isLongHair) {
        super(name, sex, weight, height, dateOfBirth, arrivingDate);
        this.character = character;
        this.isClawsTrimmed = isClawsTrimmed;
        this.isLongHair = isLongHair;
        this.setHumanAgeEquivalenceMultiplier(8);
        this.setDeathRate(0.005f);
    }

    //#region Getters and Setters
    public CatCharacter getCharacter() {
        return character;
    }

    public void setCharacter(CatCharacter character) {
        this.character = character;
    }

    public boolean isClawsTrimmed() {
        return isClawsTrimmed;
    }

    public void setClawsTrimmed(boolean clawsTrimmed) {
        isClawsTrimmed = clawsTrimmed;
    }

    public boolean isLongHair() {
        return isLongHair;
    }

    public void setLongHair(boolean longHair) {
        isLongHair = longHair;
    }
    //#endregion

    @Override
    public void cry() {
        System.out.println("Meow!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name: " + this.getName() +
                ", sex: " + this.getSex() +
                ", age: " + this.getAge() +
                ", human age equivalent: " + this.getHumanAgeEquivalence() +
                ", weight: " + this.getWeight() + "kg" +
                ", height: " + this.getHeight() + "m" +
                ", character: " + character +
                ", its claws are cut: " + isClawsTrimmed +
                ", has long hair: " + isLongHair +
                ", arrived on: " + this.getArrivingDate() +
                '}';
    }
}
