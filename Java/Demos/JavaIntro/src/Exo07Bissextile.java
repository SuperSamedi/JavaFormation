import java.util.Scanner;

public class Exo07Bissextile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez une année : ");
        int year = Integer.parseInt(sc.nextLine());

        boolean bissextile = year % 4 == 0 && (year % 100 > 0 || year % 400 == 0);

            if (bissextile){
            System.out.println(year + " est une année bissextile");
        }
            else{
            System.out.println(year + " n'est pas une année bissextile.");
        }
    }
}
