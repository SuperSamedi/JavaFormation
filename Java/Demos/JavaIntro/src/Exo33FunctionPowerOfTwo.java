import java.util.Scanner;

public class Exo33FunctionPowerOfTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result;

        System.out.println("Enter an integer...");
        int choice = Integer.parseInt(sc.nextLine());
        result = raiseToPowTwo(choice);

        System.out.println(choice + " raised to the power of 2 is " + result);
    }

    private static int raiseToPowTwo(int x){
        int result = 1;
        for (int i = 0; i < 2; i++) {
            result = result * x;
        }
        return result;
    }
}
