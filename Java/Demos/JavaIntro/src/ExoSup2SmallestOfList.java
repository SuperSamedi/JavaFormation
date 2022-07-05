import java.util.Scanner;

public class ExoSup2SmallestOfList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currentSmallest;

        int i = 0;
        System.out.println("Entrez un nombre entier...");
        int choice = Integer.parseInt(sc.nextLine());
        i++;
        System.out.println(i + " nombre sur 10 encode");
        currentSmallest = choice;
        while(i < 10){
            System.out.println("Entrez un nombre entier...");
            choice = Integer.parseInt(sc.nextLine());

            //We can check here if it's the first time we run the loop instead of before the loop.

            if (choice < currentSmallest){
                currentSmallest = choice;
            }

            i++;
            System.out.println(i + " nombres sur 10 encodes");
        }

        System.out.printf("\n Le plus petit nombre que vous avez encode est : " + currentSmallest);
        System.out.println();
    }
}
