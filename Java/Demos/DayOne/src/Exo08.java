import java.util.Scanner;

public class Exo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Le panier est-il vide ? true / false");
        boolean panierVide = Boolean.parseBoolean(sc.nextLine());
        if (panierVide) {
            System.out.println("Ne lance pas la balle !");
        }
        else {
            System.out.println("Êtes-vous prêt ? true /false");
            boolean pret = Boolean.parseBoolean(sc.nextLine());
            if (pret) {
                System.out.println("Lance la balle");
            }
            else {
                System.out.println("Ne lance pas la balle");
            }
        }
    }
}
