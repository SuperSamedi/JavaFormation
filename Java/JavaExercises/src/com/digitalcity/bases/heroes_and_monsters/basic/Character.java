package com.digitalcity.bases.heroes_and_monsters.basic;

public abstract class Character {
    private String characterType;
    private final int endurance;
    private final int strength;
    private final int maxHitPoints;
    private int hitPoints;

    public Character() {
        this.endurance = generateStat();
        this.strength = generateStat();
        this.maxHitPoints = endurance + getStatModifier(this.endurance);
        this.hitPoints = this.maxHitPoints;
    }

    //#region Getters and Setters
    public String getCharacterType(){
        return this.characterType;
    }

    protected void setCharacterType(String type){
        this.characterType = type;
    }

    public int getEndurance(){
        return this.endurance;
    }

    public int getStrength() {
        return strength;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public boolean isDead(){
        return getHitPoints() <= 0;
    }
    //#endregion

    public int strike(Character target){
        int dmg = Dice.roll(4) + getStatModifier(getStrength());
        target.getHit(dmg);
        return dmg;
    }

    public void getHit(int dmg){
        setHitPoints(getHitPoints() - dmg);
    }

    private int generateStat(){
        int result = 0;
        int[] rolls = Dice.roll(6, 4, 3);

        for (int roll :
                rolls) {
            result += roll;
        }

        return result;
    }

    public int getStatModifier(int baseStat){
        int result = 2;

        if (baseStat < 15){
            result = 1;
        }
        if (baseStat < 10){
            result = 0;
        }
        if (baseStat < 5){
            result = -1;
        }

        return result;
    }
}
