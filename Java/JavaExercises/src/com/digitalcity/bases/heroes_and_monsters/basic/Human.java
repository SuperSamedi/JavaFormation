package com.digitalcity.bases.heroes_and_monsters.basic;

public class Human extends Hero {
    private final int enduranceBonus = 1;
    private final int strengthBonus = 2;

    public Human(){
        super();
        setCharacterType("Human");
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + enduranceBonus;
    }

    @Override
    public int getStrength() {
        return super.getStrength() + strengthBonus;
    }
}
