import java.util.Scanner;

public class Exo14BallThrower2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ballStock = 3;

        System.out.println("Bip bop ! Lanceur de balles 3000 prêt !");
        System.out.println(ballStock + " balles disponibles.");

        while (ballStock > 0){
            System.out.println("Êtes-vous prêt ? true / false");
            boolean ready = Boolean.parseBoolean(sc.nextLine());

            if (ready) {
                System.out.println("BOOM !");
                ballStock--;
                System.out.println("Balles restantes : " + ballStock);
            }
            else{
                System.out.println("Erreur : le joueur n'est pas prêt.");
            }
        }

        System.out.println("Bip bop. lanceur de balles 3000 shutting down...");
    }
}
