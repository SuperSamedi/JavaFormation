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
        if (getSideA() < 0
            || getSideB() < 0
            || getSideC() < 0) {
            throw new TriangleException(MessageBadTriangle.SIDE_NEGATIVE);
        }

        // Sides should not have a length of zero.
        if (getSideA() == 0
            || getSideB() == 0
            || getSideC() == 0) {
            throw new TriangleException(MessageBadTriangle.SIDE_ZERO);
        }

        // The addition of any 2 sides should be greater than the third side.
        if (  getSideA() >= getSideB() + getSideC()
            || getSideB() >= getSideA() + getSideC()
            || getSideC() >= getSideA() + getSideB()) {
            throw new TriangleException(MessageBadTriangle.SIDE_TOO_LONG);
        }


        // We check the triangle type once we passed all non-triangle situations check.
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
