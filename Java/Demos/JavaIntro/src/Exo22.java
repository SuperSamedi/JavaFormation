import java.util.Scanner;

public class Exo22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] les6Entiers = new int[6];

        for (int i = 0; i < les6Entiers.length; i++){
            System.out.println("Entrez 1 nombre entier...");
            int nbr = Integer.parseInt(sc.nextLine());
            les6Entiers[i] = nbr;
        }

        System.out.println("Vous avez entre ces 6 nombres :");
        for (int elem : les6Entiers){
            System.out.print(elem + ", ");
        }

    }
}
