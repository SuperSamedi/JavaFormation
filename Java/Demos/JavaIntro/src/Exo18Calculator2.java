import java.util.Scanner;

public class Exo18Calculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bip bop ! Bienvenue dans le Super Calculator 3000 !");
        boolean mathing = true;

        while(mathing){
            System.out.println("\n \n Nouveau calcul !");
            System.out.println("Choisissez un nombre entier : ");
            int a = Integer.parseInt(sc.nextLine());

            System.out.println("Choisissez un opérateur : + - * / %");
            String operator = sc.nextLine();

            System.out.println("Choisissez un deuxième nombre entier :");
            int b = Integer.parseInt(sc.nextLine());

            double result = 0;
            boolean error = false;
            boolean divZero = false;

            switch(operator){
                case "+" :
                    result = a + b;
                    break;
                case "-" :
                    result = a - b;
                    break;
                case "*" :
                    result = a * b;
                    break;
                case "/" :
                    if (b == 0){
                        error = true;
                        divZero = true;
                    }
                    else {
                        result = (double)a / b;
                    }
                    break;
                case "%" :
                    result = a % b;
                    break;
                default :
                    error = true;
            }

            if (error)
            {
                if (divZero){
                    System.out.println("ERREUR ! DIVISION PAR ZERO ! EFFONDREMENT DE L'UNIVERS IMMINENT !");
                }
                else{
                    System.out.println("Erreur : opérateur inconnu.");
                }
                return;
            }

            System.out.println(String.format("%s %s %s = %s", a, operator, b, result));

            System.out.println("Voulez vous faire un autre calcul ? true / false");
            mathing = Boolean.parseBoolean((sc.nextLine()));
        }
    }
}
