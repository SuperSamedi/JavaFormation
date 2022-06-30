package com.digitalcity.bases.car_race;

import java.util.ArrayList;

public class Pilot {
    //#region Attributes
    private String name;
    private Car car;
    private ArrayList<Integer> lapsTimes;
    //endregion

    //#region Constructors
    public Pilot(String name, Car car) {
        this.name = name;
        this.car = car;
        lapsTimes = new ArrayList<>();
    }
    //#endregion

    //#region Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }
    public ArrayList<Integer> getLapsTimes() {
        return lapsTimes;
    }
    //#endregion

    public void runLap(Circuit circuit){
        int distance = circuit.getDistance();
        float speed = getCar().getSpeed();
        int lapTime = (int)(distance / speed); //time in seconds
        addTime(lapTime);
    }

    private void addTime(int time){
        lapsTimes.add(time);
    }

    public int getTotalTime(){
        int total = 0;
        for (int time : lapsTimes) {
            total += time;
        }
        return total;
    }

    public static String secondsToTimeStamp(int sec){
        int hoursTotal, minutesTotal, secondsTotal;
        int hours, minutes, seconds;

        secondsTotal = sec;
        seconds = secondsTotal % 60;
        minutesTotal = secondsTotal / 60;
        minutes = minutesTotal % 60;
        hoursTotal = minutesTotal / 60;
        hours = hoursTotal % 24;

        return (String.format("%02d:%02d:%02d", hours,minutes,seconds));
    }

    @Override
    public String toString() {
        return "Pilot{" + name + ", driving a " + car + "}";
    }
}
