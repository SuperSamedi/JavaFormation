package com.digitalcity.advanced.exceptions_enums_generics_io_annotations.competition;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompetitionUI {
    private final Scanner scan = new Scanner(System.in);
    private Competition<Judoka> competitionOfJudoka = null;

    public void start(){
        System.out.println("New competition");

//        competitionOfJudoka = new Competition<>("JudoKO", Class<Judoka>());

        Judoka ash = null;
        Judoka misty = null;

        Judoka brock = null;


        try{
            ash = new Judoka("Ash", "Ketchum", 60);
            misty = new Judoka("Misty", "Williams", 50);
            brock = new Judoka ("Brock", "Harrison", 70);
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        List<Judoka> judokas = new ArrayList<>();
        judokas.add(ash);
        judokas.add(misty);
        judokas.add(brock);

        for (Judoka judoka : judokas) {
            try{
                competitionOfJudoka.register(judoka);
                System.out.println("src.Competitor registered: " + judoka);
            }
            catch(RuntimeException ex){
                System.out.println(ex.getMessage());
            }
        }

        // Display competitors
        try{
            System.out.println("Competitors: \n" + competitionOfJudoka.getCompetitors());
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        // Run the competition
        try{
            System.out.println("Starting the competition!");
            competitionOfJudoka.runCompetition();
            System.out.println("src.Competition has ended.");
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        //Display results
        System.out.println(competitionOfJudoka.getCompetitors());

        // Display ranking
        try{
            System.out.println("Ranking: \n" + competitionOfJudoka.getRanking());
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        // Display winners
        try{
            System.out.println("Winners : \n" + competitionOfJudoka.getWinners());
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

        //With Inputs.
//        boolean invalidParticipantLimit = true;
//        while(invalidParticipantLimit){
//            System.out.println("How many participants?");
//            int numberOfParticipants = Integer.parseInt(scan.nextLine());
//            try{
//                top4 = new src.Competition(numberOfParticipants);
//                invalidParticipantLimit = false;
//            }
//            catch (RuntimeException ex){
//                System.out.println(ex.getMessage());
//            }
//        }
//
//        boolean registrationOpen = true;
//        while (registrationOpen){
//            System.out.println("Choose");
//            System.out.println("1=Start src.Competition. \n2=Register new participant");
//            switch (Integer.parseInt(scan.nextLine())){
//                case 1:
//                    try{
//                        top4.runCompetition();
//                        System.out.println("Starting src.Competition!");
//                        System.out.println("Participants: ");
//                        System.out.println(top4.getAthletes());
//                        registrationOpen = false;
//                    }
//                    catch (RuntimeException ex){
//                        System.out.println(ex.getMessage());
//                    }
//                    break;
//                case 2:
//                    registerNewParticipant();
//                    break;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//
//        System.out.println("Winner(s): ");
//        System.out.println(top4.getWinners());
//    }
//
//    private void registerNewParticipant(){
//        System.out.println("New Participant: ");
//        System.out.println("First Name: ");
//        String fName = scan.nextLine();
//        System.out.println("Last Name: ");
//        String lName = scan.nextLine();
//        src.Competitor newAthlete = new src.Competitor(fName, lName);
//
//        try{
//            top4.register(newAthlete);
//        }
//        catch (RuntimeException ex){
//            System.out.println(ex.getMessage());
//        }
    }
}
