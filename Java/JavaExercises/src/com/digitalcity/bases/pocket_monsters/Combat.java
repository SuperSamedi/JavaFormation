package com.digitalcity.bases.pocket_monsters;

public class Combat {
    Trainer[] trainers = new Trainer[2];

    public Combat(){
        Trainer blue = new Trainer("Blue");
        Trainer red = new Trainer("Red");


        Creature pikachu = new Creature("Pikachu", 6, 3, 10, 20);
        Creature bulbazaure = new Creature("Bulbazaure", 8, 6, 5, 25);

        blue.addCreature(pikachu);
        red.addCreature(bulbazaure);

        blue.setCurrentCreature(blue.getCreatures().get(0));
        red.setCurrentCreature(red.getCreatures().get(0));

        trainers[0] = blue;
        trainers[1] = red;
    }

    //Duelers choose an action.
    private void duelersChooseAction() {
        for (int i = 0; i < trainers.length; i++) {
            trainers[i].setCurrentActionChoice(Trainer.actionChoice());
        }
    }

    private void displayDuelersChoices(){
        System.out.println("Duelers choose their action...");
        for (Trainer trainer : trainers) {
            switch (trainer.getCurrentActionChoice()){
                case 1:
                    System.out.println(trainer.getName() + " chooses to change creature.");
                    break;
                case 2:
                    System.out.println(trainer.getName() + " chooses to attempt a dodge.");
                    break;
                case 3:
                    System.out.println(trainer.getName() + " chooses to restore their creature's armor.");
                    break;
                case 4:
                    System.out.println(trainer.getName() + " chooses to attack.");
                    break;
                default:
                    System.out.println("!!Error: impossible choice!!");
                    break;
            }
        }

    }
}
