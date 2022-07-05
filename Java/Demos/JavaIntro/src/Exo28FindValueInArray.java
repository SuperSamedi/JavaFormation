import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exo28FindValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        //Generate random array of length 10
        int[] myArray = new int[10];
        for (int i = 0; i < myArray.length; i++) {
            int randomNumber = rng.nextInt(11);
            myArray[i] = randomNumber;
        }

        //Display initial array (for debugging)
        System.out.println("Initial Array : ");
        System.out.print("[");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i]);
            if (i < myArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.println("What value do you want to search in the array?");
        int valueToFind = Integer.parseInt(sc.nextLine());

        ArrayList<Integer> valueFound = new ArrayList<>();

        //Find every instance of the chosen value in the list and record in a list every index where we found it.
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == valueToFind) {
                valueFound.add(i);
            }
        }

        //Check if we found any.
        if (valueFound.size() == 0) {
            System.out.println("Sorry, the value " + valueToFind + " has not been found in the array.");
            return;
        }

        //Display the index(es) where we found the value in the array.
        System.out.println("The value " + valueToFind + " has been found a the following index(es) : ");
        System.out.print("[");
        for (int i = 0; i < valueFound.size(); i++) {
            System.out.print(valueFound.get(i));
            if (i < valueFound.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
