package com.digitalcity.bases.heroes_and_monsters.advanced;


import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static boolean playing = true;

    public static void main(String[] args) {
        int difficulty = 5; //Number of monster to slay in order to win.

        while (playing){
            System.out.println("Welcome to Shorewood's Adventure!");
            Hero hero = generateHero();
            String ok = scan.nextLine();
            System.out.println("You are a " + hero.getCharacterType() + " hero.");
            System.out.println("Your stats are : ");
            System.out.println("Endurance : " + hero.getEndurance());
            System.out.println("Strength : " + hero.getStrength());
            System.out.println("Hit Points : " + hero.getMaxHitPoints());
            String ok2 = scan.nextLine();
            System.out.println("Venture through the forest and reach the other side.");
            System.out.println("Careful though! Many monsters wander through these wood...");
            String ok3 = scan.nextLine();
            System.out.println("You begin your adventure and enter the forest.");

            boolean adventuring = true;
            while (adventuring){
//                Combat combat = new Combat(hero);
//                combat.runCombat();

                if (hero.isDead()){
                    //Game Over.
                    adventuring = false;
                    gameOver(hero);
                    continue;
                }

                if (hero.getSlainMonsters() >= difficulty){
                    //Win
                    adventuring = false;
                    win(hero);
                    continue;
                }

                hero.rest();
                System.out.println("You rest a bit and get on your way when you feel refreshed.");
                String ok4 = scan.nextLine();
            }
        }
    }

    private static void gameOver(Hero hero){
        //Summary
        System.out.println("You died...");
        displayAdventureSummary(hero);

        //Restart? Quit?
        displayRestartOrQuit();
    }

    private static void win(Hero hero){
        System.out.println("Congratulations!");
        System.out.println("You got through the dark woods.");
        displayAdventureSummary(hero);
        displayRestartOrQuit();
    }

    private static void displayAdventureSummary(Hero hero){
        System.out.println("You slayed " + hero.getSlainMonsters() + " monsters.");
        System.out.println("You collected " + hero.getGoldAmount() + " gold coins.");
        System.out.println("And collected " + hero.getLeatherAmount() + " leather scraps.");
        System.out.println("=================================");
        String ok = scan.nextLine();
    }

    private static  void displayRestartOrQuit(){
        System.out.println("Choose an action...");
        System.out.println("1 = Start a new adventure.");
        System.out.println("2 = Retire from adventuring.");
        int input = Integer.parseInt(scan.nextLine());

        switch (input) {
            case 1 -> Main.playing = true;
            case 2 -> Main.playing = false;
            default -> Main.playing = true;
        }
    }

    private static Hero generateHero(){
        Hero hero;

        int roll = Dice.roll(2);
        switch (roll){
            case 1:
                hero = new Human();
                break;
            case 2:
                hero = new Dwarf();
                break;
            default:
                hero = new Human();
                break;
        }

        return hero;
    }
}
