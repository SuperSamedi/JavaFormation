import java.util.ArrayList;
import java.util.Random;

public class Exo40GiversReceiversRandom {
    static ArrayList<String> alreadyReceiving = new ArrayList<String>();
    static String[] givers = new String[]{"Hulk", "Spiderman", "Thor", "Ironman", "Black Widow"};

    public static void main(String[] args) {
        String[] receivers = givers.clone();

        for (int i = 0; i < givers.length; i++) {
            receivers[i] = pickFrom(givers);
        }

        Display(givers, receivers);
    }

    private static String pickFrom(String[] array){
        Random rng = new Random();
        String pick = array[rng.nextInt()];
        return pick;
    }

    private static void Display(String[] giversArray, String[] receiversArray){
        for (int i = 0; i < giversArray.length; i++) {
            System.out.println(giversArray[i] + " -> " + receiversArray[i]);
        }
    }
}
