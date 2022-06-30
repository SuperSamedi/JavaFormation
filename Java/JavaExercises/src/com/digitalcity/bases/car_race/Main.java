package com.digitalcity.bases.car_race;

public class Main {
    public static void main(String[] args) {
        Circuit mushroomLoop = new Circuit("Mush Loop", 3);
        Race mushroomCup = new Race("The Mushroom Cup", mushroomLoop, 3);
        Car wingGlider = new Car("Garage Mario", "Wing Glider", 25, 55);
        Car bigBuggy = new Car("Peach's Rides", "The Big Buggy", 35, 45 );
        Car shellDrill = new Car("Bowser Factory", "The Shell Drill", 10, 75);
        Pilot toad = new Pilot("Toad", wingGlider);
        Pilot mario = new Pilot("Mario", bigBuggy);
        Pilot bowser = new Pilot("Bowser", shellDrill);

        mushroomCup.addPilot(toad);
        mushroomCup.addPilot(mario);
        mushroomCup.addPilot(bowser);

        System.out.println();
        System.out.println();
        System.out.println("Welcome to " + mushroomCup.getName() + "!");
        System.out.println();
        System.out.println("Get set!");
        System.out.println("...3...");
        System.out.println("...2...");
        System.out.println("...1...");
        System.out.println(".......");
        System.out.println("GOOOOO!");

        mushroomCup.runRace();

        mushroomCup.displayFastestPilot(mushroomCup.getFastestPilot());
    }
}
