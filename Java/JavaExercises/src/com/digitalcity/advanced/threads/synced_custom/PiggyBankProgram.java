package com.digitalcity.advanced.threads.synced_custom;

// Créez une classe Tirelire.
// Cette tirelire contiendra une certain quantité d'argent.
//
// Créez une classe Etrenne (enfant de Thread) qui va rajoute
// tous les X temps( en secondes) une certaine qtt d'argent dans une
// certaine tirelire.
//
// Il devra aussi être possible d'arrêter une Etrenne.
//
// Faite en sorte que les classes créées soit Thread Safe.

import java.util.Scanner;

public class PiggyBankProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PiggyBank piggy = new PiggyBank();
        Allowance christmasAllowance = new Allowance(piggy, 25, 5);

        christmasAllowance.start();

        while(true) {
            System.out.printf("Press 'Enter' to check your piggy bank balance.");
            scan.nextLine();
            System.out.println("Euros in your piggy bank : " + piggy.getBalance());
            System.out.println();
        }
    }
}
