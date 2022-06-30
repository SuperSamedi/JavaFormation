package com.digitalcity.bases.heroes_and_monsters.basic;

public class Wolf extends Monster implements IPossessLeather {
    private int leatherAmount;

    public Wolf(){
        super();
        setCharacterType("Wolf");
        this.leatherAmount = Dice.roll(4);
    }

    @Override
    public int getLeatherAmount() {
        return leatherAmount;
    }
}
