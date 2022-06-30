package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.util.Random;

@NonCompetitive( {Locality.INTERNATIONAL, Locality.NATIONAL} )
public class JavelinThrower extends Competitor {
    private int strength;
    private int yearOfExperience;

    /** Instantiate a src.JavelinThrower
     * @param strength must be between 30 and 50.
     * @param yearOfExperience must be between 0 and 20. */
    public JavelinThrower(String firstName, String lastName, int strength, int yearOfExperience) {
        super(firstName, lastName);
        this.setStrength(strength);
        this.setYearOfExperience(yearOfExperience);
    }


    public int getStrength() {
        return strength;
    }

    public int getYearOfExperience() {
        return yearOfExperience;
    }

    private void setStrength(int value){
        if (value < 30 || value > 50){
            throw new IllegalArgumentException("Error - strength must be between 30 and 50.");
        }
        this.strength = value;
    }

    public void setYearOfExperience(int value) {
        if (value < 0 || value > 20){
            throw new IllegalArgumentException("Error - yearOfExperience must be between 0 and 20.");
        }
        yearOfExperience = value;
    }

    @Override
    public int perform() {
        Random rng = new Random();
        float result = getStrength() + getYearOfExperience() * ( 70 + rng.nextInt(21) ) / 100f;
        return (int)result;
    }
}
