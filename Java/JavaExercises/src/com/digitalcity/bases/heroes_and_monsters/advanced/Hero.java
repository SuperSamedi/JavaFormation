package com.digitalcity.bases.heroes_and_monsters.advanced;



import java.util.Scanner;

public abstract class Hero extends Character implements IPossessGold, IPossessLeather {
    private Scanner scan = new Scanner(System.in);
    private int goldAmount;
    private int leatherAmount;
    private int monstersSlain;

    public Hero(){
        super();
        this.setBoardSign("H");
        this.setGoldAmount(0);
        this.setLeatherAmount(0);
        this.monstersSlain = 0;
        this.setPosition(Board.getBoard()[0].length / 2, Board.getBoard().length / 2);
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

    //#region Movement
    public String askPlayerForMovementInput(){
        System.out.println("Move? Z=Up - Q=Left - S=Down - D=Right.");
        return scan.nextLine();
    }
    //#endregion
}
