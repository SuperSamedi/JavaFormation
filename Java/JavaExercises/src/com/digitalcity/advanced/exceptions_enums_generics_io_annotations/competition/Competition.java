package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;
import com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition.exceptions.*;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Competition<C extends Competitor> implements ICompetition<C> {
    private final Locality locality;
//    private final int competitorsLimit; // If equals 0 -> infinite.
    private final Map<C, Integer> competitors = new HashMap<>();
    private List<C> ranking;
    private String name;
    private final Class<C> clazz;


    // Default competition : locale.
    public Competition(String name, Class<C> clazz) {
        this.locality = Locality.LOCAL;
        this.name = name;
        this.clazz = clazz;
        //this.competitorsLimit = this.locality.getCompetitors();
    }

    public Competition(Locality locality, String name, Class<C> clazz) {
        this.locality = locality;
        this.name = name;
        this.clazz = clazz;
    }


    public Map<C, Integer> getCompetitors() {
        return competitors;
    }
    public String getName(){
        return name;
    }


    public void runCompetition() {
        // Cannot run competition if it is already over.
        if (isOver()) {
            throw new CompetitionStateException(isOver(), false);
        }

        // Cannot run a competition with less than 2 participants.
        if (competitors.size() < 1){
            throw new CompetitionCannotRunWithoutParticipants();
        }

        for (C competitor : competitors.keySet()) {
            competitors.put(competitor, competitor.perform());
        }

        ranking = generateRanking();
        levelUp(getWinners().keySet());
        distributePrizeMoney(getWinners().keySet());
    }

    private void levelUp(Set<C> competitors) {
        for (C competitor : competitors) {
            switch (competitor.getLevel()){
                case LOCAL -> competitor.setLevel(Locality.REGIONAL);
                case REGIONAL -> competitor.setLevel(Locality.NATIONAL);
                case NATIONAL -> competitor.setLevel(Locality.INTERNATIONAL);
            }
        }
    }

    public void register(C competitor){
        // Cannot register competitor if competition is already over.
        if (isOver()){
            //throw exception with details. Will work for every situation where state check is required.
            throw new CompetitionStateException(isOver(), false);
        }

        if (competitor.getLevel().ordinal() > this.locality.ordinal()){
            throw new IllegalArgumentException("src.Competitor is too strong for the competition.");
        }

        // Cannot register competitor if limit of participant is already reached.
        // If limit equals 0, limit is infinite. So we never throw exception related to limit reach if there is no limit.
        if (locality.getCompetitorsLimit() != 0 && competitors.size() >= locality.getCompetitorsLimit()){
            //throw exception with details
            throw new AthletesLimitReachedException(locality.getCompetitorsLimit());
        }

        // Cannot register competitor if already registered.
        if (competitors.containsKey(competitor)){
            throw new IllegalArgumentException("Error - src.Competitor already registered.");
        }

        NonCompetitive annotation = competitor.getClass().getAnnotation((NonCompetitive.class));
        if (annotation != null){
            Locality[] localities = annotation.value();
            for (Locality loc : localities) {
                if (loc == locality){
                    throw new IllegalArgumentException("Error - src.Competitor is non-competitive.");
                }
            }
        }

        competitors.put(competitor, null);
    }

    // <? extends C> means all classes that are children of C.
    public void register(Collection<? extends C> competitors){
        for (C competitor : competitors) {
            register(competitor);
        }
    }

    public void unregister(C competitor){
        // Cannot unregister competitor if competition is already over.
        if (isOver()){
            //throw exception with details. Will work for every situation where state check is required.
            throw new CompetitionStateException(isOver(), false);
        }

        // Cannot unregister competitor if not registered.
        if (!competitors.containsKey(competitor)) {
            throw new IllegalArgumentException("Error - src.Competitor is not registered.");
        }

        competitors.remove(competitor);
    }

    public Map<C, Integer> getWinners(){
        // Cannot get winners if competition is not over.
        if (!isOver()){
            // Throw exception with details. Will work for every situation where state check is required.
            throw new CompetitionStateException(isOver(), true);
        }

        Map<C, Integer> winners = new HashMap<>();

        // Find the highest score among results
        int highestScore = findHighestResult(competitors);

        // Get all entries which have a score that equal the highest score.
        for (Map.Entry<C, Integer> entry : competitors.entrySet()) {
            if (entry.getValue() == highestScore){
                winners.put(entry.getKey(), entry.getValue());
            }
        }

        return winners;
    }

    private int findHighestResult(Map<C, Integer> map){
        int highestScore = 0;
        for (Map.Entry<C, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestScore){
                highestScore = entry.getValue();
            }
        }
        return highestScore;
    }

    public boolean isOver(){
        return ranking != null;
    }

    private List<C> generateRanking(){
        List<C> ranking = new ArrayList<>();

        for (C competitor : competitors.keySet()) {
            boolean placed = false;
            for (int i = 0; i < ranking.size() && !placed; i++) {
                C currentAthlete = ranking.get(i);
                double currentScore = competitors.get(currentAthlete);
                double scoreToPlace = competitors.get(competitor);

                if (scoreToPlace > currentScore){
                    ranking.set(i, currentAthlete);
                    placed = true;
                }
            }

            if (!placed){
                ranking.add(competitor);
            }
        }

        return ranking;
    }

    public List<C> getRanking(){
        return new ArrayList<>(ranking);
    }

    // <? super C> indicate all the class that are parents of ? (In this case, it still needs to be children of src.Competitor has we defined 'C' has a child of src.Competitor.
    // '?' is called a wild card.
    public void transferCompetitorsTo(Competition<? super C> otherCompetition){
        otherCompetition.register( competitors.keySet() );
    }

    // Generic method.
//    public static <Type extends Competitor> Competition<Type> combineTwoCompetition(Competition<Type> compA, Competition<Type> compB){
//        Competition<Type> newComp = new Competition<Type>();
//        compA.transferCompetitorsTo(newComp);
//        compB.transferCompetitorsTo(newComp);
//        return newComp;
//    }

    public void distributePrizeMoney(Collection<C> winners){
        for (C winner : winners) {
            winner.addEarnings(locality.getPrizeMoney() / winners.size());
        }
    }

    // Save and Load System


    public void logCompetition(){

    }

    public void write(C compToLog) {
        String verifiedName = getName().replaceAll(" ", "-")
                .replaceAll("[\\\\/:*?\"<>|]", "");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy");
        String fileName = verifiedName + LocalDate.now().format(dtf);

        if (compToLog != null){
            throw new IllegalArgumentException("Error - arg should not be null.");
        }

        try(PrintStream ps = new PrintStream(new FileOutputStream(fileName))) {
            ps.println(clazz.getSimpleName());
            for (C competitor : competitors.keySet()) {
                PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
                Field[] fields = competitor.getClass().getFields();
                for (Field field : fields) {
                    System.out.println(field);
                }
            }
//            ps.println("First name, last name, date of birth, total earnings");
//            ps.printf("\n%s, %s", compToLog.getFirstName(), compToLog.getLastName(), compToLog.getDateOfBirth(), compToLog.getTotalEarnings());
        }
        catch (IOException ex){

        }
        catch(IntrospectionException ex){

        }
    }

    public void read(){

    }
}
