import java.util.Scanner;

public class Exo07 {
    public static void main(String[] args) {
        // Demo string comparaison
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        System.out.println(message.equals("Bonjour"));

        // Exo

        System.out.println("Insérez une année : ");
        int annee = Integer.parseInt(sc.nextLine());

        boolean divisiblePar4 = annee % 4 == 0;
        boolean divisiblePar100 = annee % 100 == 0;
        boolean divisiblePar400 = annee % 400 == 0;

        if ((divisiblePar4 && !divisiblePar100) || divisiblePar400) {
            System.out.println("L'année est bissextile");
        }
        else {
            System.out.println("L'année n'est pas bissextile");
        }
    }
}
