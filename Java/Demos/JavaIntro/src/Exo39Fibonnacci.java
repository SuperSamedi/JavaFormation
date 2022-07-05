import java.util.Scanner;

public class Exo39Fibonnacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fibonnaccing = true;

        while  (fibonnaccing){
            System.out.println("Findout the value of the Fibonnacci sequence at index... ");
            int input = Integer.parseInt(sc.nextLine());
            System.out.println("The value in the Fibonnacci sequence at the index " + input + " is " + fibonnacci(input));
        }
    }

    private static int fibonnacci(int index){
        if (index == 0 || index == 1){
            return index;
        }

        int f0 = 0;
        int f1 = 1;
        int f2 = 1;

        for (int i = 2; i <= index; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }

        return f2;
    }

    private static int fibonnacciRecursive(int index){
        if (index < 2){
            return index;
        }
        return fibonnacciRecursive(index - 2) + fibonnacciRecursive(index - 1);
    }
}
