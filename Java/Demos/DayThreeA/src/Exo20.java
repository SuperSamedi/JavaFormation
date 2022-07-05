import java.util.Scanner;

public class Exo20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez un nombre");
        int nombre = Integer.parseInt(sc.nextLine());
        System.out.println("Entrez un exposant");
        int exposant = Integer.parseInt(sc.nextLine());

        int resultat = 1;

        int i = 0;
        while (i < exposant) {
            resultat = resultat * nombre;
            i++;
        }

        System.out.println(resultat);
    }
}
