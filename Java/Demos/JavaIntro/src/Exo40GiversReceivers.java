import java.util.ArrayList;
import java.util.Random;

public class Exo40GiversReceivers {
    public static void main(String[] args) {
        String[] givers = new String[]{"Hulk", "Spiderman", "Thor", "Ironman", "Black Widow"};

        givers = randomizedStringArray(givers);
        String[] receivers = givers.clone();
        shiftArrayElementToTheLeft(receivers);
        Display(givers, receivers);
    }

    private static void shiftArrayElementToTheLeft(String[] array){
        String temp = array[0];

        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1){
                array[i] = array[i+1];
            }
            else{
                array[i] = temp;
            }
        }
    }

    private static String[] randomizedStringArray(String[] initialArray){
        Random rng = new Random();
        String[] randomizedArray = new String[initialArray.length];
        ArrayList<Integer> usedIndexes = new ArrayList<Integer>();
        for (int i = 0; i < randomizedArray.length; i++) {
            boolean isUnique = false;
            int randomIndex;

            do {
                randomIndex = rng.nextInt(initialArray.length);
                if (!usedIndexes.contains(randomIndex)) {
                    isUnique = true;
                }
            } while(!isUnique);

            usedIndexes.add(randomIndex);
            randomizedArray[i] = initialArray[randomIndex];
        }
        return randomizedArray;
    }

    private static void Display(String[] giversArray, String[] receiversArray){
        for (int i = 0; i < giversArray.length; i++) {
            System.out.println(giversArray[i] + " -> " + receiversArray[i]);
        }
    }
}
