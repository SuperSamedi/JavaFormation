import java.util.Random;

public class Exo32MergeAndSortTwoArrays {
    static Random rng = new Random();

    public static void main(String[] args) {
        //Generate random array of length 10
        int[] array1 = generateRandomIntegerArray(10, -100, 101);
        int[] array2 = generateRandomIntegerArray(10, -100, 101);
        boolean array1IsEmpty = false;
        boolean array2IsEmpty = false;
        int lowestFromArray1;
        int lowestFromArray2;

        System.out.println("Array 1: ");
        displayIntegerArray(array1);
        System.out.println("Array 2: ");
        displayIntegerArray(array2);

        int[] mergedArray = new int[array1.length + array2.length];

        for (int i = 0; i < mergedArray.length; i++){
            lowestFromArray1 = lowestIntegerOfArray(array1);
            lowestFromArray2 = lowestIntegerOfArray(array2);

            if (array1IsEmpty){
                lowestFromArray1 = lowestIntegerOfArray(array2);
            }
            else if(array2IsEmpty){
                lowestFromArray2 = lowestIntegerOfArray(array1);
            }

            if (lowestFromArray1 <= lowestFromArray2){
                mergedArray[i] = lowestFromArray1;

                //Rebuild array1 without its lowest int
                if(array1.length > 1){
                    array1 = rebuildArrayWithoutInteger(array1, lowestFromArray1);
                }
                else{
                    array1IsEmpty = true;
                }
            }
            else{
                mergedArray[i] = lowestFromArray2;

                //Rebuild array2 without its lowest int
                if (array2.length > 1) {
                    array2 = rebuildArrayWithoutInteger(array2, lowestFromArray2);
                }
                else{
                    array2IsEmpty = true;
                }
            }
        }

        System.out.println("merged array: ");
        displayIntegerArray(mergedArray);
    }

    private static int lowestIntegerOfArray(int[] array){
        int lowest = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (i == 0){
                lowest = array[i];
            }

            if (array[i] < lowest){
                lowest = array[i];
            }
        }
        return lowest;
    }

    private static int[] rebuildArrayWithoutInteger(int[] array, int remove){
        boolean isPresent = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == remove) {
                isPresent = true;
            }
        }

        if (isPresent){
            int[] newArray = new int[array.length - 1];
            boolean removed = false;

            for (int i = 0; i < array.length; i++){
                if (removed){
                    newArray[i - 1] = array[i];
                }
                else {
                    if (array[i] == remove){
                        removed = true;
                    }
                    else{
                        newArray[i] = array[i];
                    }
                }
            }
            return newArray;
        }
        return array;
    }

    private static void displayIntegerArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] generateRandomIntegerArray(int length, int lowerBound, int upperBound){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            int randomNumber = rng.nextInt(lowerBound, upperBound);
            array[i] = randomNumber;
        }
        return array;
    }
}
