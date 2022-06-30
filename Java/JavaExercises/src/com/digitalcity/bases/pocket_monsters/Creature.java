package com.digitalcity.bases.pocket_monsters;

import java.util.Random;

public class Creature {
    Random rng = new Random();
    private String name;
    private int strength;
    private int armor;
    private int speed;
    private int maxHitPoint;
    private int currentHitPoint;
    private int dodgeBonus;

    public Creature(String name, int str, int arm, int spd, int hp){
        this.name = name;
        this.strength = str;
        this.armor = arm;
        this.speed = spd;
        this.maxHitPoint = hp;
        this.currentHitPoint = this.maxHitPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxHitPoint() {
        return maxHitPoint;
    }

    public void setMaxHitPoint(int hitPoint) {
        this.maxHitPoint = hitPoint;
    }

    public int getCurrentHitPoint() {
        return currentHitPoint;
    }

    public void setCurrentHitPoint(int currentHitPoint) {
        this.currentHitPoint = currentHitPoint;
    }

    private int getDodgeBonus() {
        return dodgeBonus;
    }

    private void setDodgeBonus(int dodgeBonus) {
        this.dodgeBonus = dodgeBonus;
    }

    public int getDodgeChance() {
        return getSpeed() * 2  + getDodgeBonus();
    }

    public void attack(Creature target){
        boolean criticalStrike = rollDice(5); //Crit chance is 5%
        if (criticalStrike){
            System.out.println(getName() + " attacks with a critical strike! ");
            target.receiveDamage(getStrength() * 2);
        }
        else{
            System.out.println(getName() + "attacks!");
            target.receiveDamage(getStrength());
        }
    }

    public void receiveDamage(int dmg){
        int damage = dmg;

        //Try to dodge
        boolean dodged = rollDice(getDodgeChance());
        if (dodged){
            damage = 0;
            System.out.println(getName() + " dodged the attack!");
        }

        //Calculate armor modifier
        damage -= getArmor();

        setCurrentHitPoint(getCurrentHitPoint() - damage);
        System.out.println(getName() + " receives " + damage + " damage.");
    }

    public void dodge(){
        setDodgeBonus(50);
    }

    //Armor action

    public boolean rollDice(int percent){
        boolean successful = false;

        int roll = rng.nextInt(1, 101);
        if (roll <= percent){
            successful = true;
        }

        return successful;
    }

    public void resetTurnBonuses(){
        setDodgeBonus(0);
    }
}
