package com.example.demoo.model;

import java.util.HashMap;

public class Cavalier {
    private String nom;
    private String nomFamille;
    private HashMap<String, Cheval> chevaux;

    // Constructeur


    public Cavalier(String nom, String nomFamille) {
        this.nom = nom;
        this.nomFamille = nomFamille;
        this.chevaux = new HashMap<>();
    }

    public Cavalier(String nom, String nomFamille, HashMap<String, Cheval> chevaux) {
        this.nom = nom;
        this.nomFamille = nomFamille;
        this.chevaux = chevaux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public HashMap<String, Cheval> getChevaux() {
        return chevaux;
    }

    public void addCheval(Cheval chevalAAjouter) {
        this.chevaux.put(chevalAAjouter.getNom(), chevalAAjouter);
    }
}
