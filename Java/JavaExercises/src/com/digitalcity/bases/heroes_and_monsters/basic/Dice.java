package com.digitalcity.bases.heroes_and_monsters.basic;

import java.util.ArrayList;
import java.util.Random;

public class Dice {
    private static Random rng = new Random();

    public static int roll(int faces){
        return (rng.nextInt(faces) + 1);
    }

    //Roll x diceAmount with y faces and take the top z rolls
    public static int[] roll(int faces, int diceAmount, int top){
        int[] topRolls = new int[top];
        ArrayList<Integer> allRolls = new ArrayList<>();

        for (int i = 0; i < diceAmount; i++) {
            allRolls.add(roll(faces));
        }

        //Find top rolls
        for (int i = 0; i < topRolls.length; i++) {
            Integer highestRoll = 0;
            for (int j = 0; j < allRolls.size(); j++) {
                if (allRolls.get(j) > highestRoll){
                    highestRoll = allRolls.get(j);
                }
            }
            topRolls[i] = highestRoll;
            if (allRolls.contains(highestRoll)){
                allRolls.remove(highestRoll);
            }
        }

        return topRolls;
    }
}
