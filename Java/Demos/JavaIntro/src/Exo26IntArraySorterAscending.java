import java.util.Random;

public class Exo26IntArraySorterAscending {
    public static void main(String[] args) {
        Random rng = new Random();

        int myArray[] = new int[10];
        for (int i = 0; i< myArray.length; i++){
            int randomNumber = rng.nextInt(11);
            myArray[i] = randomNumber;
        }

        //Display initial array :
        System.out.println("Initial Array : ");
        for (int elem : myArray){
            System.out.println(elem);
        }

        //
        int loops = 0;
        int passes = 0;
        for (int j = 0; j < myArray.length; j++){
            for (int i = 0; i < myArray.length - 1 - passes; i++){
                loops++;
                if (myArray[i] > myArray[i + 1]){
                    //Switch numbers
                    myArray[i] = myArray[i] + myArray[i + 1];
                    myArray[i + 1] = myArray[i] - myArray[i + 1];
                    myArray[i] = myArray[i] - myArray[i + 1];
                }
            }
            passes++;
        }

        //Display sorted array :
        System.out.println("Sorted Array : ");
        for (int elem : myArray){
            System.out.println(elem);
        }

        System.out.println("Loops : " + loops);
    }
}
