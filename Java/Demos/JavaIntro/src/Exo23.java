public class Exo23 {
    public static void main(String[] args) {
        int puissancesde2[] = new int[10];
        int exposantDeDepart = 2;

        for (int i = 0; i < 10; i++){
            puissancesde2[i] = (int)Math.pow(2, i + 1);
        }

        int index = 0;
        for(int elem : puissancesde2){
            System.out.println(index++ + " - " + elem);
        }
    }
}
