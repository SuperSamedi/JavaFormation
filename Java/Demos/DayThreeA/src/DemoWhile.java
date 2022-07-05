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
//        while (!stop) {
//            System.out.println("Voulez-vous stopper la boucle ? true / false");
//            stop = Boolean.parseBoolean(sc.nextLine());
//        }

        int j = 0;
        do {
            System.out.println("Je suis dans la boucle alors que j est >= 0");
        } while(j < 0);

//        int nb = Integer.parseInt(sc.nextLine());
//        while (nb < 1 || nb > 10) {
//            nb = Integer.parseInt(sc.nextLine());
//        }
//
//        int nb2;
//        do {
//            nb2 = Integer.parseInt(sc.nextLine());
//        } while (nb2 < 1 || nb2 > 10);

        for (j = 0; j < 10; j++) {
            System.out.println(j);
        }

        System.out.println(j);

    }
}
