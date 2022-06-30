package com.digitalcity.bases.car_race;

public class Circuit {
    //#region Attributes
    private String name;
    private int distance; //In km
    //#endregion

    //#region Constructors
    public Circuit(String name, int distance){
        this.name = name;
        this.distance = distance;
    }
    //#endregion

    //#region Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }
    //endregion
}
