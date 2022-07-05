import java.util.Arrays;
import java.util.Random;

public class Exo35FunctionMergeTwoArrays {
    static Random rng = new Random();

    public static void main(String[] args) {
        int[] array1 = generateRandomIntegerArray(5, 0, 11);
        int[] array2 = generateRandomIntegerArray(5, 0, 11);
        int[] mergedArray = mergeTwoArrays(array1, array2);

        System.out.println();
        System.out.println("Array 1:");
        System.out.println(Arrays.toString(array1));
        System.out.println("Array 2:");
        System.out.println(Arrays.toString(array2));
        System.out.println();
        System.out.println("Merged array:");
        System.out.println(Arrays.toString(mergedArray));
    }

    private static int[] mergeTwoArrays(int[] arrayA, int[] arrayB){
        int[] resultArray = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < resultArray.length ; i++) {
            if (i < arrayA.length){
                resultArray[i] = arrayA[i];
            }else{
                resultArray[i] = arrayB[i - arrayA.length];
            }
        }
        return resultArray;
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
