import java.util.Scanner;

public class Exo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nombre 1");
        int nb1 = Integer.parseInt(sc.nextLine());
        System.out.println("Entrez l'opérateur (+, -, *, /)");
        String op = sc.nextLine();
        System.out.println("Entrez le nombre 2");
        int nb2 = Integer.parseInt(sc.nextLine());

        double result = 0;

        boolean error = false;
        boolean divZero = false;

        switch(op) {
            case "+":
                result = nb1 + nb2;
                break;
            case "-":
                result = nb1 - nb2;
                break;
            case "*":
                result = nb1 * nb2;
                break;
            case "/":
                if (nb2 == 0) {
                    error = true;
                    divZero = true;
                }
                else {
                    result = (double) nb1 / nb2;
                }
                break;
            default:
                error = true;
                break;
        }

        if (error) {
            if (divZero) {
                System.out.println("Division par 0 impossible");
            }
            else {
                System.out.println("Erreur d'encodage");
            }
        }
        else {
            System.out.printf("%s %s %s = %s", nb1, op, nb2, result);
        }
    }
}
