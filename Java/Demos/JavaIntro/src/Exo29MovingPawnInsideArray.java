import java.util.Random;
import java.util.Scanner;

public class Exo29MovingPawnInsideArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        int arrayLength = 10;
        int pawnPosition = 0; //Initial position
        boolean playing = true;

        //Generate random array of length 10
        int[] myArray = new int[arrayLength];
        for (int i = 0; i < myArray.length; i++) {
            int randomNumber = rng.nextInt(10);
            myArray[i] = randomNumber;
        }
        myArray[0] = pawnPosition;

        while(playing){
            //Display array
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println("Current state of the array : ");
            System.out.print("[ ");
            for (int i = 0; i < myArray.length; i++) {
                if (i == pawnPosition){
                    System.out.print("X");
                }
                else{
                    System.out.print(myArray[i]);
                }

                if (i < myArray.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" ]");

            char left = 'q';
            char right = 'd';
            char stop = 's';

            System.out.println("Awaiting input... (Q = Left, D = Right, S = Stop");
            //Getting input
            String s = sc.nextLine();
            char input = s.charAt(0);

            if (input == left && pawnPosition > 0){
                //Move left
                myArray[pawnPosition] = myArray[pawnPosition - 1];
                pawnPosition--;
            }
            else if (input == right && pawnPosition < (myArray.length - 1)){
                //Move right
                myArray[pawnPosition] = myArray[pawnPosition + 1];
                pawnPosition++;
            }
            else if (input == stop){
                playing = false;
            }

            //Display and loop
        }
    }
}
