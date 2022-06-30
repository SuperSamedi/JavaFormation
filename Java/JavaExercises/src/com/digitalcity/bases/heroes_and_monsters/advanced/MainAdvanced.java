package com.digitalcity.bases.heroes_and_monsters.advanced;
import com.digitalcity.bases.heroes_and_monsters.advanced.*;

import java.util.Scanner;


public class MainAdvanced {
    private static Scanner scan = new Scanner(System.in);
    private static boolean playing = true;

    public static void main(String[] args) {
        Board board = new Board(15, 15);
        board.fill();
        Hero player = generateHero();
        Board.updateTileContent(player, player.getPosX(), player.getPosY());
        board.generateMonsters();
        board.displayState();
        String movementInput;
        Direction moveDir = Direction.DOWN;
        boolean playing = true;
        while(playing){
            boolean correctInput = false;
            while (!correctInput){
                movementInput = player.askPlayerForMovementInput();
                switch (movementInput.toUpperCase()){
                    case "Z" -> {
                        moveDir = Direction.UP;
                        correctInput = true;
                    }
                    case "Q" -> {
                        moveDir = Direction.LEFT;
                        correctInput = true;
                    }

                    case "S" -> {
                        moveDir = Direction.DOWN;
                        correctInput = true;
                    }
                    case "D" -> {
                        moveDir = Direction.RIGHT;
                        correctInput = true;
                    }
                    default -> System.out.println("Input not recognized...");
                }
            }
            player.move(moveDir);
            Board.displayState();
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
            case 1 -> MainAdvanced.playing = true;
            case 2 -> MainAdvanced.playing = false;
            default -> MainAdvanced.playing = true;
        }
    }

    private static Hero generateHero(){
        Hero hero;

        int roll = Dice.roll(2);
        hero = switch (roll) {
            case 1 -> new Human();
            case 2 -> new Dwarf();
            default -> new Human();
        };

        return hero;
    }
}
