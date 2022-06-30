package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionAlreadyRegisteredThisAthleteException extends IllegalArgumentException {
    public CompetitionAlreadyRegisteredThisAthleteException(){
        super("This athlete was already registered to this competition.");
    }
}
