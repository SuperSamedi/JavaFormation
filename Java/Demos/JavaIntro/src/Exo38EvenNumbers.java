public class Exo38EvenNumbers {
    public static void main(String[] args) {
        printEvenNumbers(0, 200);
    }

    private static void printEvenNumbers(int lowerBound, int upperBound){
        for (int i = lowerBound; i < upperBound + 1; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
