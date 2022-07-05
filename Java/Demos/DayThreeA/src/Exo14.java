import java.util.Scanner;

public class Exo14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stock = 3;
        boolean pret;
        while (stock > 0) {
            System.out.println("Êtes-vous prêt ? true / false");
            pret = Boolean.parseBoolean(sc.nextLine());
            if (pret) {
                System.out.println("Lance la balle");
                stock--;
            }
            else {
                System.out.println("Ne lance pas la balle");
            }
        }

        System.out.println("Il n'y a plus de balle");


    }
}
