package com.example.demoo;

import com.example.demoo.model.Cavalier;
import com.example.demoo.model.Cheval;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Cheval ch = new Cheval("Jolyjumper", 50, 70);
        Cheval ch2 = new Cheval("Pégase");

        Cavalier caval = new Cavalier("Jacques", "Jean");

        caval.addCheval(ch);
        caval.addCheval(ch2);
        System.out.println(caval.getChevaux().get(ch.getNom()).courir());
    }
}
