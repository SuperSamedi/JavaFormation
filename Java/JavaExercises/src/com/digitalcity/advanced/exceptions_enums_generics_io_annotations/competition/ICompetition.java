package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.util.Collection;
import java.util.Map;

public interface ICompetition<P extends Competitor> {
    void runCompetition();
    void register(P competitor);
    void register(Collection<? extends P> competitors);
    void unregister(P competitor);
    Map<P, Integer> getWinners();
    boolean isOver();
}
