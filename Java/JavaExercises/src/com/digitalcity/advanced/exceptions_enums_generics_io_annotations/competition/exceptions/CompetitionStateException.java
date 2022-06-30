package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions;

public class CompetitionStateException extends IllegalStateException {
    private final boolean currentState;
    private final boolean expectedState;

    public CompetitionStateException(boolean currentState, boolean expectedState) {
        super("Error - src.Competition is " + (currentState ? "" : "not ") + "over. To execute this action the competition should " + (expectedState ? "" : "not ") + "be over.");
        this.currentState = currentState;
        this.expectedState = expectedState;
    }

    public boolean isCurrentState() {
        return currentState;
    }

    public boolean isExpectedState() {
        return expectedState;
    }
}
