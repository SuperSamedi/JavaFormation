package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.util.Random;

public class Runner extends Competitor {
    private int averageSpeed;
    private int weight;

    /**
     * Instantiate a src.Runner
     * @param averageSpeed must be between 8 and 13.
     * @param weight must be between 60 and 200.
     */
    public Runner(String firstName, String lastName, int averageSpeed, int weight) {
        super(firstName, lastName);
        this.setAverageSpeed(averageSpeed);
        this.setWeight(weight);
    }


    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int value) {
        if (value < 8 || value > 13){
            throw new IllegalArgumentException("Error - averageSpeed must be between 8 and 13.");
        }
        averageSpeed = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int value) {
        if (value < 60 || value > 200){
            throw new IllegalArgumentException("Error - weight must be between 60 and 200.");
        }
        weight = value;
    }


    @Override
    public int perform() {
        Random rng = new Random();
        float result = (float)getAverageSpeed() / getWeight() * (110 + rng.nextInt(21));
        return (int)result;
    }
}
