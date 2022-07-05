import java.util.Scanner;

public class Exo30InsertIntoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] myArray = new int[]{1, 2, 3, 4, 5};

        //Display initial array (for debugging)
        System.out.println("Initial array: ");
        displayIntegerArray(myArray);


        System.out.println("Choose an integer to insert into this array...");
        int valueToInsert = Integer.parseInt(sc.nextLine());

        int[] newArray = new int[myArray.length + 1];

        //Insert chosen value
        int temp = valueToInsert;
        for (int i = 0; i < myArray.length; i++){
            if (temp < myArray[i]){
                newArray[i] = temp;
                temp = myArray[i];
            }
            else {
                newArray[i] = myArray[i];
            }

            if (i == myArray.length - 1){
                newArray[i + 1] = temp;
            }
        }

        myArray = newArray.clone();

        System.out.println("New array: ");
        displayIntegerArray(myArray);
    }

    private static void displayIntegerArray(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
