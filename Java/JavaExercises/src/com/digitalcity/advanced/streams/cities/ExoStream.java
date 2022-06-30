package com.digitalcity.advanced.streams.cities;



import java.util.List;

public class ExoStream {

    public static void main(String[] args) {

        VilleService service = new VilleService();
        // TODO testez vos methodes

        System.out.println();
        System.out.println("Every ville served by VilleService:");
        List<String> villeNames = service.getCityNames();
        System.out.println(villeNames);

        System.out.println();
        System.out.println("Ville with the highest tax:");
        Ville highestTaxVille = service.getWithHighestTaxe();
        System.out.println(highestTaxVille);

        System.out.println();
        System.out.println("Habitant who paid the most taxes so far.");
        Habitant theUnluckyOne = highestTaxVille.getHabitants().iterator().next();
        theUnluckyOne.payerTaxe(10_000);
        Habitant habitantWithMostPaidTaxes = service.getMostTaxed();
        System.out.println(habitantWithMostPaidTaxes);

        System.out.println();
        System.out.println("All streets of the Villes");
        List<String> streets = service.getStreets();
        System.out.println(streets);

        System.out.println();
        System.out.println("Let's tax villes if their name begins with 'B'");
        service.taxe('B');

        System.out.println("Habitants in Brequin");
        System.out.println(service.getAllHabitants("Brequin"));

    }

}
