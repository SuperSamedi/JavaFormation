package com.digitalcity.bases.heroes_and_monsters.basic;


public class DragonWhelp extends Monster implements IPossessGold, IPossessLeather {
    private final int enduranceBonus = 1;
    private int goldAmount;
    private int leatherAmount;

    public DragonWhelp(){
        super();
        setCharacterType("Dragon Whelp");
        this.goldAmount = Dice.roll(6);
        this.leatherAmount = Dice.roll(4);
    }

    @Override
    public int getEndurance() {
        return super.getEndurance() + enduranceBonus;
    }

    @Override
    public int getGoldAmount() {
        return goldAmount;
    }

    @Override
    public int getLeatherAmount() {
        return leatherAmount;
    }
}
