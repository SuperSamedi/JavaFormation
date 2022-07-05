public class Exo15Multiple1to9 {
    public static void main(String[] args) {

        int display;

        for (int multiple = 1; multiple < 10; multiple++)
        {
            for (int i = 1; i < 11; i++){
                display = i * multiple;
                System.out.printf(String.valueOf(display) + " - ");
            }

            System.out.println();
        }
    }
}
