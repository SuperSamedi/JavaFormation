package com.digitalcity.advanced.streams.cities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Ville {

    private final int codePostal;
    private final String nom;
    private final Set<Habitant> habitants;
    private double montantTaxe;


    public Ville(int codePostal, String nom, Collection<Habitant> habitants, double montantTaxe) {
        this.codePostal = codePostal;
        this.nom = nom;
        this.habitants = new HashSet<>(habitants);
        this.montantTaxe = montantTaxe;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getNom() {
        return nom;
    }

    public double getMontantTaxe(){
        return this.montantTaxe;
    }

    public Set<Habitant> getHabitants(){
        return habitants;
    }

    public void ajouter(Habitant habitant){
        this.habitants.add(habitant);
    }

    public void retirer(Habitant habitant){
        this.habitants.remove(habitant);
    }

    public void taxer(){
        this.habitants.forEach(h -> h.payerTaxe(montantTaxe));
    }


    @Override
    public String toString() {
        return "Ville{" +
                "codePostal=" + codePostal +
                ", nom='" + nom + '\'' +
                ", montantTaxe=" + montantTaxe +
                '}';
    }
}
