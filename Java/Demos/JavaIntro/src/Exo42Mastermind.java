import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Exo42Mastermind {
    static int correctlyPlaced;
    static int correctSign;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean masteringMinds = true;
        correctlyPlaced = 0;
        correctSign = 0;
        String possibleSigns = "AZERTY";
        ArrayList<String> hiddenSet = randomSet(4, possibleSigns);
        System.out.println(hiddenSet);

        while(masteringMinds){
            String guess = "";

            boolean validGuess = false;
            while (!validGuess) {
                System.out.println("Possible Signs : A - Z - E - R - T - Y");
                System.out.println("Guess a set of 4 signs...");
                guess = sc.nextLine();

                if (guess.length() != 4){
                    System.out.println("ERROR : invalid set.");
                    validGuess = false;
                }
                else{
                    guess = guess.toUpperCase();
                    validGuess = true;
                }
            }
            System.out.println("Your guess = " + guess);
            feedback(hiddenSet, stringToArrayList(guess));
            displayGameState();
            if (correctlyPlaced == 4){
                System.out.println("Yay! You win!");
                masteringMinds = false;
            }
        }
    }

    private static void feedback(ArrayList<String> code, ArrayList<String> guess){
        ArrayList<String> hiddenSet = (ArrayList<String>)code.clone();
        ArrayList<String> userGuess = (ArrayList<String>)guess.clone();
        correctlyPlaced = 0;
        correctSign = 0;

        for (int i = 0; i < hiddenSet.size(); i++) {
            if (userGuess.get(i).equals(hiddenSet.get(i))){
                correctlyPlaced++;
                hiddenSet.set(i, "X");
                userGuess.set(i, "O");
            }
        }

        for (int i = 0; i < hiddenSet.size(); i++) {
            if (hiddenSet.contains(userGuess.get(i))){
                correctSign++;
            }
        }
    }

    private static ArrayList<String> stringToArrayList(String strg){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < strg.length(); i++) {
            result.add(String.valueOf(strg.charAt(i)));
        }
        return result;
    }

    private static ArrayList<String> randomSet(int signs, String s){
        Random rng = new Random();
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < signs; i++) {
            char randomChar = s.charAt(rng.nextInt(s.length()));
            result.add(String.valueOf(randomChar));
        }

        return result;
    }

    private static void displayGameState(){

        System.out.println("You have : " + correctlyPlaced + " pin(s) correctly placed.");
        System.out.println("and");
        System.out.println("You have : " + correctSign + " pin(s) of the correct sign.");
    }
}
