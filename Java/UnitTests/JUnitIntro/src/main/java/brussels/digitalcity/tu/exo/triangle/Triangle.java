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
//        this.sideA = sideA;
//        this.sideB = sideB;
//        this.sideC = sideC;
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


    public TriangleType checkValidity() throws TriangleException {
        // Sides should not be of negative length.
        if (getSideA() < 0 || getSideB() < 0 || getSideC() < 0) {
            throw new TriangleException("Error - Triangle sides cannot have a negative length.");
        }

        // Sides should not have a length of zero.
        if (getSideA() == 0 || getSideB() == 0 || getSideC() == 0) {
            throw new TriangleException("Error - Triangle sides cannot have a length of zero.");
        }

        // The addition of any 2 sides should be greater than the third side.
        if (  getSideA() >= getSideB() + getSideC()
            || getSideB() >= getSideA() + getSideC()
            || getSideC() >= getSideA() + getSideB()) {
            throw new TriangleException("Error - The specified sides cannot form a triangle. One side cannot be greater than the sum of the two other sides.");
        }


        // When all three sides are equal, the triangle is equilateral.
        if (getSideA() == getSideB()
            && getSideA() == getSideC()){
            return TriangleType.EQUILATERAL;
        }

        // If only two sides are equal, it is isosceles.
        if (getSideA() == getSideB()
            || getSideA() == getSideC()
            || getSideB() == getSideC()) {
            return TriangleType.ISOSCELES;
        }

        // Otherwise, it is scalene.
        return TriangleType.SCALENE;
    }
}
