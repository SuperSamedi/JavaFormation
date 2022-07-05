package com.example.demoo.model;

import java.util.Random;

public class Cheval {
    // Attribut (en privé, puisqu'on y accède via les getter et setter)
    // Public : accès partout
    // Private : accès uniquement dans la classe
    // Default : accès dans le package
    // Protected : accès dans le package et les classes enfants
    private String nom;
    private int vitesseMin;
    private int vitesseMax;

    // Constructeur : méthode appelé lors de la création d'un objet de la classe Cheval
    public Cheval(String nom) {
        this.nom = nom;
    }

    public Cheval(String nom, int vitesseMin, int vitesseMax) {
        System.out.println("Je passe dans le constructeur");
        if (nom.equals("")) {
            this.nom = "No name";
        }
        else {
            this.nom = nom;
        }
        this.vitesseMin = vitesseMin;
        this.vitesseMax = vitesseMax;
    }



    //#region Getter and Setter

    // Getter : méthode pour récupérer la valeur d'un attribut
    public String getNom() {
        return this.nom;
    }

    public int getVitesseMin() {
        return vitesseMin;
    }

    // Setter : la méthode pour changer la valeur d'un attribut
    public void setVitesseMin(int vitesseMin) {
        this.vitesseMin = vitesseMin;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }
    //#endregion

    public int courir() {
        Random random = new Random();
        return random.nextInt(vitesseMin, vitesseMax);
    }

    public int courir(int bonus) {
        Random random = new Random();
        return random.nextInt(vitesseMin, vitesseMax) + bonus;
    }

    public static void henir() {
        System.out.println("Brrrrr");
    }

    @Override
    public String toString() {
        return "Bonjour";
    }
}
