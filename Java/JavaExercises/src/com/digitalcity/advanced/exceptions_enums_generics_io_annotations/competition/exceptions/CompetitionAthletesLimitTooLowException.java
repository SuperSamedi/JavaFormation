package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionAthletesLimitTooLowException extends IllegalArgumentException {
    public CompetitionAthletesLimitTooLowException(){
        super("Not enough participant.");
    }
}
