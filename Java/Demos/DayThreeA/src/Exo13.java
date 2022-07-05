public class Exo13 {
    public static void main(String[] args) {
        int table = 2;
        int multiplicateur = 1;
        while (multiplicateur < 11) {
            System.out.printf("%s * %s = %s \n",
                    multiplicateur,
                    table,
                    multiplicateur * table);
            multiplicateur++;
        }
    }
}
