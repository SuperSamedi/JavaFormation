import java.util.Scanner;

public class Exo24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Combien de joueurs y a-t-il ? Maximum 10.");
        int players = Integer.parseInt(sc.nextLine());

        if (players > 10){
            players = 10;
        }
        else if (players < 1){
            players = 1;
        }

        int scores[] = new int[players];
        int totalScores = 0;

        for (int i = 0; i < scores.length; i++){
            System.out.println("Score du joueur " + (i + 1));
            int score = Integer.parseInt(sc.nextLine());
            scores[i] = score;
            totalScores += score;
        }

        System.out.println("La moyenne des scores et de : " + ((double)totalScores / scores.length));
    }
}
