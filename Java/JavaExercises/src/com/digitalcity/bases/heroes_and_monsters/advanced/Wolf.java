package com.digitalcity.bases.heroes_and_monsters.advanced;



public class Wolf extends Monster implements IPossessLeather {
    private int leatherAmount;

    public Wolf(){
        super();
        setCharacterType("Wolf");
        setBoardSign("W");
        this.leatherAmount = Dice.roll(4);
    }

    @Override
    public int getLeatherAmount() {
        return leatherAmount;
    }
}
