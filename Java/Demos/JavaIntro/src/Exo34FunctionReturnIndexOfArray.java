import java.util.ArrayList;
import java.util.Arrays;

public class Exo34FunctionReturnIndexOfArray {
    public static void main(String[] args) {
        int[] myArray = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(myArray));

        int valueToFindTheIndexOf = 3;
        int index = findIndex(myArray, valueToFindTheIndexOf);

        System.out.println("Index of " + valueToFindTheIndexOf + " is " + index);
    }

    private static int findIndex(int[] array, int value){
        boolean found = false;
        int index = -1;

        for (int i = 0; i < array.length && !found; i++){
            if (array[i] == value){
                index = i;
                found = true;
            }
        }

        return index;
    }
}
