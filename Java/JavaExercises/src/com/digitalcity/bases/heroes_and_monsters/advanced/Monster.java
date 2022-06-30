package com.digitalcity.bases.heroes_and_monsters.advanced;


public abstract class Monster extends Character {
    private boolean isHidden;


    public Monster() {
        this.isHidden = true;
    }

    public boolean isHidden(){
        return isHidden;
    }

    public void setIsHidden(boolean value){
        this.isHidden = value;
    }

    public static Monster getRandomMonster(){
        int roll = Dice.roll(3);
        return switch (roll) {
            case 1 -> new Wolf();
            case 2 -> new Orc();
            case 3 -> new DragonWhelp();
            default -> new Wolf();
        };
    }
}
