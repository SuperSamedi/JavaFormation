package com.digitalcity.bases.car_race;

import java.util.ArrayList;

public class Race {
    //#region Attributes
    private String name;
    private Circuit circuit;
    private int numberOfLaps;
    private ArrayList<Pilot> pilots;
    //#endregion

    //#region Constructors
    public Race(String name, Circuit circuit, int laps) {
        this.name = name;
        this.circuit = circuit;
        this.numberOfLaps = laps;
        pilots = new ArrayList<>();
    }
    //#endregion

    //#region Getters and Setters
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    private void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public int getNumberOfLaps() {
        return numberOfLaps;
    }

    private void setNumberOfLaps(int numberOfLaps) {
        this.numberOfLaps = numberOfLaps;
    }

    public ArrayList<Pilot> getPilots() {
        return pilots;
    }
    //#endregion


    public void addPilot(Pilot pilot){
        pilots.add(pilot);
    }

    public void runRace(){
        for (int i = 0; i < numberOfLaps; i++) {
            runALap();
            displayLapResult(i + 1);
        }
    }

    private void runALap(){
        for (Pilot pilot: pilots) {
            pilot.runLap(circuit);
        }
    }

    public Pilot getFastestPilot(){
        Pilot fastestPilot = null;

        for (int i = 0; i < pilots.size(); i++) {
            if (i == 0){
                fastestPilot = pilots.get(i);
            }
            if (pilots.get(i).getTotalTime() < fastestPilot.getTotalTime()){
                fastestPilot = pilots.get(i);
            }
        }

        return fastestPilot;
    }

    private void displayLapResult(int currentLap){
        System.out.println();
        System.out.println("Lap " + currentLap);
        for (Pilot pilot :
                pilots) {
            System.out.println(pilot.getName() + " --- " + Pilot.secondsToTimeStamp(pilot.getLapsTimes().get(currentLap - 1)));
        }
    }

    public void displayFastestPilot(Pilot pilot){
        System.out.println();
        System.out.println();
        System.out.println("Fastest pilot: " + pilot);
        System.out.println("With a time of " + Pilot.secondsToTimeStamp(pilot.getTotalTime()));
        System.out.println("Well done " + pilot.getName() + "!");
    }
}
