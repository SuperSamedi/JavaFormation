package com.digitalcity.bases.heroes_and_monsters.advanced;


public abstract class Character implements ITileContent {
    private String characterType;
    private final int endurance;
    private final int strength;
    private int hitPoints;
    private int posX;
    private int posY;
    private String boardSign;

    public Character() {
        this.endurance = generateStat();
        this.strength = generateStat();
        this.hitPoints = this.getMaxHitPoints();
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
        return this.getEndurance() + getStatModifier(this.getEndurance());
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

    public void setPosition(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getPosX(){
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getBoardSign() {
        return boardSign;
    }

    public void setBoardSign(String value) {
        boardSign = value;
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

    public void move(Direction dir){
        int oldX = posX;
        int oldY = posY;
        switch (dir) {
            case UP -> {
                if (posY > 0) {
                    posY--;
                }
            }
            case DOWN -> {
                if (posY < Board.getBoard().length - 1)
                    posY++;
            }
            case LEFT -> {
                if (posX > 0) {
                    posX--;
                }
            }
            case RIGHT -> {
                if (posX < Board.getBoard()[0].length - 1) {
                    posX++;
                }
            }
        }
        //Clear previous position
        Board.updateTileContent(null, oldX, oldY);
        //Move to new pos
        Board.updateTileContent(this, posX, posY);
        checkForCombat();
    }

    public void checkForCombat(){
        if (Board.getBoard()[posY - 1][posX].getContent() instanceof Monster //Check if monster on tile above.
            || Board.getBoard()[posY][posX - 1].getContent() instanceof Monster //Check if monster on tile on the left.
            || Board.getBoard()[posY + 1][posX].getContent() instanceof Monster //Check if monster on tile below.
            || Board.getBoard()[posY][posX + 1].getContent() instanceof Monster)//Check if monster on tile on the right.
        {
//            new Combat(Monster.getRandomMonster()){


        }
    }
}
