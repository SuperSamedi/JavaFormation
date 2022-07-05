import java.util.Scanner;

public class ExoSuppMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minimum = 0;
        int nbr;

        for (int i = 0; i < 10; i++) {
            System.out.println("Entrez un nombre");
            nbr = Integer.parseInt(sc.nextLine());

            if (i == 0) {
                minimum = nbr;
            }

            else if (nbr < minimum) {
                minimum = nbr;
            }
        }

        System.out.println("Le minimum est " + minimum);
    }
}
