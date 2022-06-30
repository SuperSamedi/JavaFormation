package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionNotOverYetException extends RuntimeException {
    public CompetitionNotOverYetException(){
        super("The competition isn ot over yet.");
    }
}
