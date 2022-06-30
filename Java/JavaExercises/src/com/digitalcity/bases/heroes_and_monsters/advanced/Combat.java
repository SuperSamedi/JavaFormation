package com.digitalcity.bases.heroes_and_monsters.advanced;


import java.util.Scanner;

public class Combat {
    private Monster monster;
    private Hero hero;
    private Scanner scan = new Scanner(System.in);

    public Combat(Hero hero, Monster monster){
        this.monster = monster;
        this.hero = hero;
    }

    public void runCombat(){
        System.out.println("A wild " + monster.getCharacterType() + " appears from behind a tree. You must fight!");
        System.out.println("It has the following stats: ");
        System.out.println("Endurance: " + monster.getEndurance());
        System.out.println("Strength: " + monster.getStrength());
        System.out.println("Hit points: " + monster.getMaxHitPoints());
        String ok = scan.nextLine();

        boolean fighting = true;
        while (fighting){
            int heroDamage = hero.strike(monster);
            if (monster.isDead()){
                hero.loot(monster);
                hero.setMonstersSlain(hero.getSlainMonsters() + 1);
                fighting = false;
                displayCombatRoundSummary(heroDamage);
            }
            else {
                int monsterDamage = monster.strike(hero);
                if (hero.isDead()){
                    fighting = false;
                }
                displayCombatRoundSummary(heroDamage, monsterDamage);
            }
        }
    }

    private void displayCombatRoundSummary(int heroDmg){
        System.out.println("You launch an attack at the " + monster.getCharacterType() + " and strike it for " + heroDmg + " damage!");
        String ok = scan.nextLine();
        if (monster.isDead()){
            System.out.println("The " + monster.getCharacterType() + " dies under your might.");

            String lootSummary = "You loot ";
            if (monster instanceof IPossessGold){
                lootSummary += ((IPossessGold) monster).getGoldAmount() + " gold coins";
            }
            if (monster instanceof IPossessGold && monster instanceof IPossessLeather){
                lootSummary += " and ";
            }
            if (monster instanceof IPossessLeather){
                lootSummary += ((IPossessLeather) monster).getLeatherAmount() + " leather scraps";
            }
            lootSummary += " from its corpse.";

            System.out.println(lootSummary);
            String ok2 = scan.nextLine();
        }
    }



    private void displayCombatRoundSummary(int heroDmg, int monsterDmg){
        System.out.println("You launch an attack at the " + monster.getCharacterType() + " and strike it for " + heroDmg + " damage!");
        String ok = scan.nextLine();
        if (monster.isDead()){
            System.out.println("The " + monster.getCharacterType() + " dies under your might.");

            String lootSummary = "You loot ";
            if (monster instanceof IPossessGold){
                lootSummary += ((IPossessGold) monster).getGoldAmount() + " gold coins";
            }
            if (monster instanceof IPossessGold && monster instanceof IPossessLeather){
                lootSummary += " and ";
            }
            if (monster instanceof IPossessLeather){
                lootSummary += ((IPossessLeather) monster).getLeatherAmount() + " leather scraps";
            }
            lootSummary += " from its corpse.";

            System.out.println(lootSummary);
            return;
        }

        System.out.println("The " + monster.getCharacterType() + " retaliates with a hit, dealing you " + monsterDmg + " damage!");
        String ok2 = scan.nextLine();
        if (hero.isDead()){
            return;
        }
    }
}
