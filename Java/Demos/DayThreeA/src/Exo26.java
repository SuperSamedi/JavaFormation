public class Exo26 {
    public static void main(String[] args) {
        int[] tab = new int[] {5, 8, 1, 2, 3};
        int nbrBoucle = 0;
        int temp;
        int passage = 0;
        boolean permutation;
        do  {
            permutation = false;
            for (int i = 0; i < tab.length - 1; i++) {
                nbrBoucle++;
                if (tab[i] > tab[i+1]) {
                    permutation = true;
                    temp = tab[i];
                    tab[i] = tab[i+1];
                    tab[i+1] = temp;
                }
            }
            passage++;
        } while (permutation);

        for (int elem : tab) {
            System.out.println(elem);
        }

        System.out.println("Nombre boucle : " + nbrBoucle);
    }
}
