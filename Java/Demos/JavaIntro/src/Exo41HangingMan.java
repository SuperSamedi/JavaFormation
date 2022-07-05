// +----+
// |    |
// |    o
// |   /|\
// |   / \
// |
//=========

import java.util.Random;
import java.util.Scanner;

public class Exo41HangingMan {
    static String word;
    static boolean[] lettersFound;
    static int maxLives = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        String[] possibleWords = new String[]{"ONION", "SUPER", "SOUPE"};
        int lives;
        int gameState; //0 = Playing, 1 = Game Over, 2 = Win
        boolean playing = true;

        System.out.println("=! Hangin' Man !=");
        System.out.println("--! New Game !--");

        gameState = 0;
        lives = maxLives;
        word = possibleWords[rng.nextInt(possibleWords.length)];
        lettersFound = new boolean[word.length()];
        for (boolean bool: lettersFound){
            bool = false;
        }

        displayState(gameState, lives);

        while(playing){
            String s = sc.nextLine();
            s = s.toUpperCase();
            char guess = s.charAt(0);

            if(updateLettersFound(guess) == false){
                lives--;
            }
            if (lives <= 0){
                gameState = 1;
                playing = false;
            }
            if (wordFound(lettersFound)){
                gameState = 2;
                playing = false;
            }

            displayState(gameState, lives);
        }
    }

    static boolean wordFound(boolean[] gate){
        boolean isFound = true;
        for (int i = 0; i < gate.length; i++) {
            if (gate[i] == false && isFound == true){
                isFound = false;
            }
        }
        return isFound;
    }

    static boolean updateLettersFound(char c){
        boolean newLetter = false;
        for (int i = 0; i < lettersFound.length; i++) {
            if (word.charAt(i) == c){
                lettersFound[i] = true;
                newLetter = true;
            }
        }
        return newLetter;
    }

    static void displayState(int state, int currentLives){
        displayLives(currentLives);
        switch (state){
            case 0: //Playing
            {
                System.out.println("Word : " + hiddenWord(word, lettersFound));
                System.out.println("Guess a letter...");
                break;
            }
            case 1: //GameOver
            {
                System.out.println("...Game Over...");
                break;
            }
            case 2: //Win
            {
                System.out.println("Word : " + hiddenWord(word, lettersFound));
                System.out.println("Pfew ! Bravo ! '^-^");
                break;
            }
        }

    }

    static void displayLives(int currentLives){
        switch (currentLives){
            case 0 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |    |    ");
                System.out.println(" |  (x-x)  ");
                System.out.println(" |   /|\\   ");
                System.out.println(" |   / \\   ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            case 1 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |    |    ");
                System.out.println(" |  (o-o)  ");
                System.out.println(" |   /|\\   ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            case 2 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |    |    ");
                System.out.println(" |  (o-o)  ");
                System.out.println(" |    |    ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            case 3 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |    |    ");
                System.out.println(" |  (o-o)  ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            case 4 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |    |    ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            case 5 :
            {
                System.out.println(" +----+    ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println(" |         ");
                System.out.println("===========");
                break;
            }
            default :
            {
                break;
            }
        }
    }

    static String hiddenWord(String word, boolean[] gate){
        String s = "";
        for (int i = 0; i < word.length(); i++) {
            if (gate[i] == true){
                s += word.charAt(i);
            }
            else {
                s += "*";
            }
        }
        return s;
    }
}
