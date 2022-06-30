package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionAthleteNumberAlreadyAtLimitException extends RuntimeException {
    private final int athleteLimit;
    private final int athletesRegistered;

    public CompetitionAthleteNumberAlreadyAtLimitException(int limit, int registrations){
        super("The competition is full. No more registrations accepted. " + registrations + "/" + limit + " registrations.");
        this.athleteLimit = limit;
        this.athletesRegistered = registrations;
    }

    public int getAthleteLimit() {
        return athleteLimit;
    }

    public int getAthletesRegistered() {
        return athletesRegistered;
    }
}
