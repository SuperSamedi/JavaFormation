public class ExerciseLogicOperators {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;
        boolean c = false;
        boolean d = !c;
        int e = 9;

        System.out.println(a > 8);
        System.out.println(b == 9);
        System.out.println(!(a != 3));
        System.out.println(!c);
        System.out.println((a < b) || c);
        System.out.println(!((a + b) != 12));
        System.out.println(((b == 5) || ((e > 10) && (a < 8))));
        System.out.println();
    }
}
