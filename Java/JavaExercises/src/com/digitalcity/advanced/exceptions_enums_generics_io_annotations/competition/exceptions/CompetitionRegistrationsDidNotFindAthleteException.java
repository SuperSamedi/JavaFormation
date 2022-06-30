package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionRegistrationsDidNotFindAthleteException extends RuntimeException {
    public CompetitionRegistrationsDidNotFindAthleteException(){
        super("Could not find the athlete in the registrations list.");
    }
}
