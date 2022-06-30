package com.digitalcity.bases.heroes_and_monsters.basic;


public abstract class Hero extends Character implements IPossessGold, IPossessLeather {
    private int goldAmount;
    private int leatherAmount;
    private int monstersSlain;

    public Hero(){
        super();
        this.setGoldAmount(0);
        this.setLeatherAmount(0);
        this.monstersSlain = 0;
    }
    //#region Getters and Setters
    @Override
    public int getGoldAmount() {
        return this.goldAmount;
    }

    public void setGoldAmount(int amount){
        this.goldAmount = amount;
    }

    private void addGoldAmount(int amount){
        setGoldAmount(getGoldAmount() + amount);
    }

    @Override
    public int getLeatherAmount() {
        return this.leatherAmount;
    }

    public void setLeatherAmount(int amount){
        this.leatherAmount = amount;
    }

    private void addLeatherAmount(int amount){
        setLeatherAmount(getLeatherAmount() + amount);
    }

    public int getSlainMonsters(){
        return this.monstersSlain;
    }

    public void setMonstersSlain(int amount){
        this.monstersSlain = amount;
    }
    //#endRegion

    public void loot(Monster targetMonster){
        if (targetMonster instanceof IPossessGold){
            addGoldAmount(((IPossessGold) targetMonster).getGoldAmount());
        }
        if (targetMonster instanceof IPossessLeather){
            addLeatherAmount(((IPossessLeather) targetMonster).getLeatherAmount());
        }
    }

    public void rest(){
        setHitPoints(getMaxHitPoints());
    }
}
