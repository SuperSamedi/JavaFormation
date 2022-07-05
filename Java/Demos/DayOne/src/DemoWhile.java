import java.util.Scanner;

public class DemoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (i < 5) {
            System.out.println("Je suis passé dans ma boucle !");
            i++;
        }
        System.out.println(i);

        boolean stop = false;
        while (!stop) {
            System.out.println("Voulez-vous stopper la boucle ? true / false");
            stop = Boolean.parseBoolean(sc.nextLine());
        }

        int j = 0;
        do {
            System.out.println("Je suis dans la boucle");
        } while(j < 0);

    }
}
