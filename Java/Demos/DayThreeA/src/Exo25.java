public class Exo25 {
    public static void main(String[] args) {
        int[] tab = new int[] {1, 2, 3, 4, 5};
        int[] tabInverse = new int[tab.length];

        for (int i = 0; i < tab.length; i++) {
            tabInverse[i] = tab[tab.length - i - 1];
        }

        for (int elem : tabInverse) {
            System.out.println(elem);
        }
    }
}
