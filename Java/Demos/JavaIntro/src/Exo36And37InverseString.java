import java.util.Scanner;

public class Exo36And37InverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Write a string that you wish to inverse...");
        String input = sc.nextLine();

        String inversedInput = inverseString(input);
        System.out.println("The inverse string of: " + input + ". is: " + inversedInput);

        if (isPalindrome(input)){
            System.out.println("Woow, " + input + " is a palindrome! :D");
        }
        else{
            System.out.println("Unfortunately, " + input + " is not a palindrome :(");
        }
    }

    private static String inverseString(String strg){
        String result = "";
        for (int i = 0; i < strg.toCharArray().length; i++) {
            result += strg.charAt(strg.length() - 1 - i);
        }
        return result;
    }

    private static boolean isPalindrome(String strg){
        boolean result = false;
        String inversedString = inverseString(strg);
        if (inversedString.equals(strg)){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
}
