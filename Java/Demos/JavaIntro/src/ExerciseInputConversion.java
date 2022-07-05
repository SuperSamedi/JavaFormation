import java.util.Scanner;

public class ExerciseInputConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Entrez la valeur de a.");
//        String aString = scanner.nextLine();
//
//        System.out.println("Entrez la valeur de b.");
//        String bString = scanner.nextLine();
//
//        int a = Integer.parseInt(aString);
//        int b = Integer.parseInt(bString);
//
//        System.out.println("Valeur de a = " + a);
//        System.out.println("Valeur de b = " + b);

        System.out.print("Quel est votre prénom ? ");
        String firstName = scanner.nextLine();

        System.out.print("Quel est votre nom de famille ? ");
        String lastName = scanner.nextLine();

        String welcomePhrase = "Bienvenue " + lastName + " " + firstName + " !";
        System.out.println(welcomePhrase);
    }
}
