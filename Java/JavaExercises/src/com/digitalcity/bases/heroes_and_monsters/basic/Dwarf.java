package com.digitalcity.bases.heroes_and_monsters.basic;

public class Dwarf extends Hero {
    private final int enduranceBonus = 2;

    public Dwarf() {
        super();
        setCharacterType("Dwarf");
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + enduranceBonus;
    }
}
