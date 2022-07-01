package com.digitalcity.bases.heroes_and_monsters.advanced;


public class Orc extends Monster implements IPossessGold {
    private final int strengthBonus = 1;
    private final int goldAmount;

    public Orc(){
        super();
        setCharacterType("Orc");
        setBoardSign("O");
        this.goldAmount = Dice.roll(6);
    }

    @Override
    public int getStrength() {
        return super.getStrength() + strengthBonus;
    }

    @Override
    public int getGoldAmount() {
        return goldAmount;
    }
}
