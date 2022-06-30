package com.digitalcity.bases.pocket_monsters;

import java.util.ArrayList;
import java.util.Random;

public class Trainer {
    private String name;
    private ArrayList<Creature> creatures;
    private Creature currentCreature;
    private int currentActionChoice;

    public Trainer(String name){
        this.name = name;
        creatures = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
    }

    public Creature getCurrentCreature(){
        return currentCreature;
    }

    public void setCurrentCreature(Creature crea) {
        this.currentCreature = crea;
    }

    public int getCurrentActionChoice() {
        return currentActionChoice;
    }

    public void setCurrentActionChoice(int currentActionChoice) {
        this.currentActionChoice = currentActionChoice;
    }

    public static int actionChoice(){
        Random rng = new Random();

        //1 = Change creature, 2 = Dodge, 3 = Block, 4 = Attack
        return rng.nextInt(1, 5);
    }

    public void addCreature(Creature crea){
        creatures.add(crea);
    }
}
