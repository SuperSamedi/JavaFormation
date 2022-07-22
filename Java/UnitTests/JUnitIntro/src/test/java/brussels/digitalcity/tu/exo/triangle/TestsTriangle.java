package brussels.digitalcity.tu.exo.triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsTriangle {

    private final Triangle tri = new Triangle();

    @BeforeEach
    void beforeEachTest() {
        tri.setSideA(1);
        tri.setSideB(1);
        tri.setSideC(1);
    }

    //#region Sides Negative Checks
    // side A can't be negative
    // side B can't be negative
    // side C can't be negative
    @Test
    @DisplayName("Side A = -1. Throw")
    void negativeOneSideAShouldThrowTriangleException(){
        tri.setSideA(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_NEGATIVE, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = -1. Throw")
    void negativeOneSideBShouldThrowTriangleException(){
        tri.setSideB(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_NEGATIVE, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = -1. Throw")
    void negativeOneSideCShouldThrowTriangleException(){
        tri.setSideC(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_NEGATIVE, ex.getMessage());
    }
    //#endregion

    //#region Sides Zero Checks
    // Side A can't be equal to 0.
    // Side B can't be equal to 0.
    // Side C can't be equal to 0.
    @Test
    @DisplayName("Side A = 0. Throw")
    void zeroSideAShouldThrowTriangleException(){
        tri.setSideA(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_ZERO, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = 0. Throw")
    void zeroSideBShouldThrowTriangleException(){
        tri.setSideB(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_ZERO, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = 0. Throw")
    void zeroSideCShouldThrowTriangleException(){
        tri.setSideC(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_ZERO, ex.getMessage());
    }
    //#endregion

    //#region Sides Too Long Checks
    // A should not be greater than B + C
    // B should not be greater than A + C
    // C should not be greater than A + B
    // A should not be equal to B + C
    // B should not be equal to A + C
    // C should not be equal to A + B
    @Test
    @DisplayName("Side A > Side B + Side C. Throw")
    void aGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideB(8);
        tri.setSideC(5);
        tri.setSideA(42);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }

    @Test
    @DisplayName("Side B > Side A + Side C. Throw")
    void bGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(3);
        tri.setSideC(18);
        tri.setSideB(124);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }

    @Test
    @DisplayName("Side C > Side A + Side B. Throw")
    void cGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(1);
        tri.setSideB(24);
        tri.setSideC(645);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }

    @Test
    @DisplayName("Side A = Side B + Side C. Throw")
    void aEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideC(42);
        tri.setSideB(24);
        tri.setSideA(42 + 24);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = Side A + Side C. Throw")
    void bEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideC(2);
        tri.setSideA(10);
        tri.setSideB(2 + 10);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = Side A + Side B. Throw")
    void cEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(12_895);
        tri.setSideB(23_256);
        tri.setSideC(12_895 + 23_256);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(MessageBadTriangle.SIDE_TOO_LONG, ex.getMessage());
    }
    //#endregion

    //#region Equilateral Check
    // 3 same sides = Equilateral
    @Test
    @DisplayName("Side A = Side B = side C. Equilateral")
    void whenAllThreeSidesAreEqualTheTriangleIsEquilateral() throws TriangleException {
        tri.setSideA(14);
        tri.setSideB(14);
        tri.setSideC(14);

        assertEquals(TriangleType.EQUILATERAL, tri.checkValidity());
    }
    //#endregion

    //#region Isosceles Checks
    // Two same sides = Isosceles
        // A = B != C -> Isosceles
        // A = C != B -> Isosceles
        // B = C != A -> Isosceles
    @Test
    @DisplayName("Side A = Side B != side C. Isosceles")
    void whenSideAAndSideBAreEqualTheTriangleIsIsosceles() throws TriangleException {
        tri.setSideA(100);
        tri.setSideB(100);
        tri.setSideC(101);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }

    @Test
    @DisplayName("Side A = Side C != side B. Isosceles")
    void whenSideAAndSideCAreEqualTheTriangleIsIsosceles() throws TriangleException {
        tri.setSideA(22);
        tri.setSideB(39);
        tri.setSideC(22);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }

    @Test
    @DisplayName("Side B = Side C != side A. Isosceles")
    void whenSideBAndSideCAreEqualTheTriangleIsIsosceles() throws TriangleException {
        tri.setSideA(6);
        tri.setSideB(9);
        tri.setSideC(9);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }
    //#endregion

    //#region Scalene Check
    // 3 different sides = Scalene
    @Test
    @DisplayName("All different sides. Scalene")
    void whenAllThreeSidesAreDifferentTheTriangleIsScalene() throws TriangleException {
        tri.setSideA(12);
        tri.setSideB(5);
        tri.setSideC(16);

        assertEquals(TriangleType.SCALENE, tri.checkValidity());
    }
    //#endregion
}
