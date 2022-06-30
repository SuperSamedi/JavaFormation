package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionCannotRunWithoutParticipants extends RuntimeException {
    public CompetitionCannotRunWithoutParticipants(){
        super("src.Competition can not run while there is less than 2 participant registered.");
    }
}
