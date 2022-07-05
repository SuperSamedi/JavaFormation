import java.util.Scanner;

public class Exo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez la valeur de a");
        String aString = sc.nextLine();
        System.out.println("Entrez la valeur de b");
        String bString = sc.nextLine();
        int a = Integer.parseInt(aString);
        int b = Integer.parseInt(bString);
        int temp;
        temp = a;
        a = b;
        b = temp;

        System.out.println("Valeur de a : " + a);
        System.out.println("Valeur de b : " + b);

//        String aString = String.valueOf(a);
    }
}
