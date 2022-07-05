import java.util.Random;
import java.util.Scanner;

public class Exo16JustePrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        System.out.println("Bienvenue au JUSTE PRIX !");

        int level = 1;
        int maxPrice = 10;
        int gains = 0;
        int tries = 0;
        boolean playing = true;

        while(playing){
            int justePrix = rng.nextInt(maxPrice + 1);;
            int guess = -1;
            tries = level * 10 / 2;

            System.out.println("Niveau " + level + ".");
            System.out.println("Trouvez le juste prix entre 0 et " + maxPrice + ".");
            System.out.println("Vous avez " + tries + " essais.");

            while (guess != justePrix){
                System.out.printf("Votre choix : ");
                guess = Integer.parseInt(sc.nextLine());
                tries--;

                if (guess > justePrix){
                    System.out.println("Trop haut ! Il vous reste " + tries + " essais.");
                }
                else if (guess < justePrix){
                    System.out.println("Trop bas ! Il vous reste " + tries + " essais.");
                }

                if (tries <= 0){
                    System.out.println("Desole mais vous avez utilise tous vos essais...");
                    System.out.println("Vous repartez avec " + gains + " euros ! \n Felicitations");
                    return;
                }
            }

            System.out.println("Bravo !");
            gains += maxPrice;
            System.out.println();

            System.out.println("Vos gains s'elevent a " + gains + "euros pour le moment.");
            System.out.println();
            System.out.println("Voulez vous : ");
            System.out.println("1. Rejouer le niveau " + level + ".");
            System.out.println("2. Passer au niveau suivant.");
            System.out.println("3. Arreter le jeu.");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1){
                System.out.println("\n Rejouons donc le niveau " + level + " !");
            }
            else if(choice == 2){
                level++;
                maxPrice = (int)Math.pow(10, level);
                System.out.println("\n Passons au niveau " + level + ".");
            }
            else if (choice == 3)
            {
                playing = false;
            }
        }

        System.out.println("Tres bien, merci d'avoir joue.");
        System.out.println("Vous repartez avec " + gains + " euros !!!");
        System.out.println("Felicitations !");
    }
}
