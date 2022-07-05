public class ExerciseInverseTwoInts {
    public static void main(String[] args) {
        int a = 5, b = 7;
        int temp;

        temp = a;
        a = b;
        b = temp;

//        InverseTwoInt(a, b);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

//    static void InverseTwoInt(int intA, int intB){
//        int temp;
//
//        temp = intA;
//        intA = intB;
//        intB = temp;
//    }
}
