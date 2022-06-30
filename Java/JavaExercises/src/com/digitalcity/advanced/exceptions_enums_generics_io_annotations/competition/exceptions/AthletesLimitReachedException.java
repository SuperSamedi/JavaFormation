package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class AthletesLimitReachedException extends RuntimeException {
    private final int limit;

    public AthletesLimitReachedException (int limit) {
        super("The limit of " + limit + " participants has been reached.");
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
