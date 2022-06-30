package com.digitalcity.bases.petshop;


import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Animal {
    private Random rng;
    private String name;
    private Sex sex;
    private float weight; //kilograms
    private float height; //meters
    private LocalDate birthDay;
    private LocalDate arrivingDate;
    private int humanAgeEquivalenceMultiplier;
    private float deathRate;
    private boolean isDead;


    public Animal(String name, Sex sex, float weight, float height, LocalDate birthDay, LocalDate arrivingDate) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.birthDay = birthDay;
        this.arrivingDate = arrivingDate;
        this.isDead = false;
        rng = new Random();
    }

    //#region Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate date) {
        this.birthDay = date;
    }

    public int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    public LocalDate getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(LocalDate arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public int getHumanAgeEquivalenceMultiplier() {
        return humanAgeEquivalenceMultiplier;
    }

    public void setHumanAgeEquivalenceMultiplier(int humanAgeEquivalenceMultiplier) {
        this.humanAgeEquivalenceMultiplier = humanAgeEquivalenceMultiplier;
    }

    public float getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(float rate) {
        this.deathRate = rate;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) {
        isDead = dead;
    }

    public int getHumanAgeEquivalence(){
        return this.getAge() * humanAgeEquivalenceMultiplier;
    }
    //#endregion

    public void cry(){
        System.out.println("?");
    }

    public boolean diedOvernight(){
        boolean died = (this.getDeathRate() >= rng.nextFloat(0f, 1.0f));
        if (died){
            this.setIsDead(true);
        }
        return died;
    }
}
