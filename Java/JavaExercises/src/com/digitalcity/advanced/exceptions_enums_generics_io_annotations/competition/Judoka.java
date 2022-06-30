package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.util.Random;

public class Judoka extends Competitor {
    private int throwPower;

    /**
     * Instantiate a judoka
     * @param throwPower Must be between 40 and 80. */
    public Judoka(String firstName, String lastName, int throwPower) {
        super(firstName, lastName);
        this.setThrowPower(throwPower);
    }


    public int getThrowPower() {
        return throwPower;
    }

    private void setThrowPower(int value) {
        if (value < 40 || value > 80){
            throw new IllegalArgumentException("Error - throwPower must be between 40 and 80.");
        }
        this.throwPower = value;
    }


    @Override
    public int perform() {
        Random rng = new Random();
        return getThrowPower() + (rng.nextInt(41) - 20);
    }
}
