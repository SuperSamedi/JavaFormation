import java.util.Scanner;

public class Exo08BallThrower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bip bop ! Lanceur de balles 3000 prêt !");
        System.out.println("Le panier est-il vide ? true / false");
        boolean basketEmpty = Boolean.parseBoolean(sc.nextLine());

        if (basketEmpty){
            System.out.println("Erreur, pas de balle disponible.");
        }
        else{
            System.out.println("Êtes-vous prêt ? true / false");
            boolean ready = Boolean.parseBoolean(sc.nextLine());

            if (ready) {
                System.out.println("Attention ! Une balle va être lancée !");
            }
            else{
                System.out.println("Erreur : le joueur n'est pas prêt.");
            }
        }
    }
}
