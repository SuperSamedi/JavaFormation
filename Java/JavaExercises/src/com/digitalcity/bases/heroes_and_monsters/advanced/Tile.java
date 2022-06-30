package com.digitalcity.bases.heroes_and_monsters.advanced;

import interfaces.ITileContent;

public class Tile {
    private ITileContent content;

    public Tile(){
        this.content = null;
    }

    public ITileContent getContent(){
        return this.content;
    }

    public void setContent(ITileContent content){
        this.content = content;
    }

    @Override
    public String toString() {
        if (content == null){
            return "[ ]";
        }
        else {
            return "[" + content.getBoardSign() + "]";
        }

    }
}
