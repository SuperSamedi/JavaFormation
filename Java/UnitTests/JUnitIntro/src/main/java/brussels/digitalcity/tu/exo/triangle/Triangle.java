package brussels.digitalcity.tu.exo.triangle;

/*
3 entiers = longueures des cotés d'un triangle.
Renvoi le type du triangle:
Scalene
Isocele
equilateral
NAT (not a triangle)
 */
public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

//
//    public Triangle(int sideA, int sideB, int sideC) {
//        if (isValid(sideA, sideB, sideC)){
//            this.sideA = sideA;
//            this.sideB = sideB;
//            this.sideC = sideC;
//        }
//    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int value) {
        sideA = value;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int value) {
        sideB = value;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int value) {
        sideC = value;
    }

    public void checkValidity(int a, int b, int c) throws TriangleException{

    }
}
