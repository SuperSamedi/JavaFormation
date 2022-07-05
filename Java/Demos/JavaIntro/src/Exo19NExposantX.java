import java.util.Scanner;

public class Exo19NExposantX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choisissez un nombre entier : ");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println("Choisissez un exposant : ");
        int exposant = Integer.parseInt(sc.nextLine());
        int result = 1;

        int i = 0;
        while(i < exposant){
            result = result * choice;
            i++;
        }

        System.out.println(choice + " ^ " + exposant + " = " + result);
    }
}
