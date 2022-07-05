import java.util.Scanner;

public class Exo27SmallestFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int recordedNumbers[] = new int[10];

        for (int i = 0; i < recordedNumbers.length; i++){
            System.out.println("Entrez un nombre entier...");
            int choice = Integer.parseInt(sc.nextLine());
            recordedNumbers[i] = choice;
            System.out.println((i + 1)  + " nombres sur 10 encodes");
        }

        int currentSmallest = 0;

        for (int i = 0; i < recordedNumbers.length; i++){
            if (i == 0){
                currentSmallest = recordedNumbers[0];
            }
            if (recordedNumbers[i] < currentSmallest){
                currentSmallest = recordedNumbers[i];
            }
        }

        System.out.printf("\n Le plus petit nombre que vous avez encode est : " + currentSmallest);
        System.out.println();
    }
}
