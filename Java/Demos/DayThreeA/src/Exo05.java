import java.util.Scanner;

public class Exo05 {
    public static void main(String[] args) {
        int jourTotal, heureTotale, minuteTotale, secondeTotal;
        int heures, minutes, secondes;

        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un nombre de secondes");

        secondeTotal = Integer.parseInt(sc.nextLine());
        secondes = secondeTotal % 60;
        minuteTotale = secondeTotal / 60;
        minutes = minuteTotale % 60;
        heureTotale = minuteTotale / 60;
        heures = heureTotale % 24;
        jourTotal = heureTotale / 24;

        System.out.printf(
                "%s jours, %s heures, %s minutes, %s secondes",
                jourTotal, heures, minutes, secondes
        );
    }
}
