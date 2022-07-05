import java.util.Scanner;

public class Exo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre prénom : ");
        String name = sc.nextLine();
        System.out.print("Entrez votre nom de famille : ");
        String lastName = sc.nextLine();

        System.out.println("Bienvenue " + name + " " + lastName + " !");
    }
}
