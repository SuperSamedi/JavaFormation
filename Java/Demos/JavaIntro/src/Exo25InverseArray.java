public class Exo25InverseArray {
    public static void main(String[] args) {
        int myArray[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int mirrorArray[] = new int[myArray.length];

        for(int i = 0; i < myArray.length; i++){
            mirrorArray[myArray.length - 1 - i] = myArray[i];
        }

        //Display array
        for (int elem : mirrorArray){
            System.out.println(elem);
        }
    }
}
