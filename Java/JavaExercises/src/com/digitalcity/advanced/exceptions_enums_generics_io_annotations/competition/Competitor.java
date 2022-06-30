package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.time.LocalDate;

public abstract class Competitor {
    private String firstName;
    private String lastName;
    private int totalEarnings;
    private Locality level;
    private LocalDate dateOfBirth;


    public Competitor(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.totalEarnings = 0;
        this.level = Locality.LOCAL;
    }

    public Competitor(String firstName, String lastName, Locality level) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.totalEarnings = 0;
        this.level = level;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    protected void setFirstName(String value) {
        firstName = value;
    }

    protected void setLastName(String value) {
        lastName = value;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public Locality getLevel() {
        return level;
    }

    public void setLevel(Locality value) {
        level = value;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void addEarnings(int value){
        if (value < 0){
            throw new IllegalArgumentException("Error - Earnings can't be below 0.");
        }
        this.totalEarnings += value;
    }


    public abstract int perform();

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " - Total earnings: " + getTotalEarnings();
    }
}
