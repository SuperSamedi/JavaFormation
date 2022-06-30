package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

public enum Locality {

    LOCAL( 100, 0),
    REGIONAL(1_000, 32),
    NATIONAL(10_000, 64),
    INTERNATIONAL(100_000, 128);


    private final int prizeMoney;
    private final int competitorsLimit;

    Locality(int prizeMoney, int competitorsLimit) {
        this.prizeMoney = prizeMoney;
        this.competitorsLimit = competitorsLimit;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCompetitorsLimit() {
        return competitorsLimit;
    }
}
