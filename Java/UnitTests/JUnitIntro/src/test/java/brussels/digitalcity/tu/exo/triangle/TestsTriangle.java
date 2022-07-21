package brussels.digitalcity.tu.exo.triangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.DescriptorKey;

import java.io.Serial;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsTriangle {
    private final Triangle tri = new Triangle();

    private int count = 0;


    @BeforeEach
    void beforeEachTest() {
        tri.setSideA(1);
        tri.setSideB(1);
        tri.setSideC(1);
        count++;
    }


    // side A can't be negative
    // Also check for big number
    // side B can't be negative
    // Also check for big number
    // side C can't be negative
    // Also check for big number
    String negativeLengthSideErrorMessage = "Error - Triangle sides cannot have a negative length.";
    @Test
    @DisplayName("Side A = -1. Throw")
    void negativeOneSideAShouldThrowTriangleException(){
        tri.setSideA(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = -1. Throw")
    void negativeOneSideBShouldThrowTriangleException(){
        tri.setSideB(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = -1. Throw")
    void negativeOneSideCShouldThrowTriangleException(){
        tri.setSideC(-1);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side A = -10,000. Throw")
    void negativeTenThousandSideAShouldThrowTriangleException(){
        tri.setSideA(-10_000);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = -10,000. Throw")
    void negativeTenThousandSideBShouldThrowTriangleException(){
        tri.setSideB(-10_000);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = -10,000. Throw")
    void negativeTenThousandSideCShouldThrowTriangleException(){
        tri.setSideC(-10_000);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(negativeLengthSideErrorMessage, ex.getMessage());
    }


    // Side A can't be equal to 0.
    // Side B can't be equal to 0.
    // Side C can't be equal to 0.
    String zeroLengthSideErrorMessage = "Error - Triangle sides cannot have a length of zero.";
    @Test
    @DisplayName("Side A = 0. Throw")
    void zeroSideAShouldThrowTriangleException(){
        tri.setSideA(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(zeroLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = 0. Throw")
    void zeroSideBShouldThrowTriangleException(){
        tri.setSideB(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(zeroLengthSideErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = 0. Throw")
    void zeroSideCShouldThrowTriangleException(){
        tri.setSideC(0);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(zeroLengthSideErrorMessage, ex.getMessage());
    }


    // A should not be greater than B + C
    // B should not be greater than A + C
    // C should not be greater than A + B
    // A should not be equal to B + C
    // B should not be equal to A + C
    // C should not be equal to A + B
    String wrongSideRatioErrorMessage = "Error - The specified sides cannot form a triangle. One side cannot be greater than the sum of the two other sides.";
    @Test
    @DisplayName("Side A > Side B + Side C. Throw")
    void aGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideB(8);
        tri.setSideC(5);
        tri.setSideA(42);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side B > Side A + Side C. Throw")
    void bGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(3);
        tri.setSideC(18);
        tri.setSideB(124);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side C > Side A + Side B. Throw")
    void cGreaterThanSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(1);
        tri.setSideB(24);
        tri.setSideC(645);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity );
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side A = Side B + Side C. Throw")
    void aEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideC(42);
        tri.setSideB(24);
        tri.setSideA(42 + 24);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side B = Side A + Side C. Throw")
    void bEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideC(2);
        tri.setSideA(10);
        tri.setSideB(2 + 10);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }

    @Test
    @DisplayName("Side C = Side A + Side B. Throw")
    void cEqualSumOfTheTwoOtherSidesShouldThrowTriangleException() {
        tri.setSideA(12_895);
        tri.setSideB(23_256);
        tri.setSideC(12_895 + 23_256);

        TriangleException ex = assertThrows( TriangleException.class, tri::checkValidity);
        assertEquals(wrongSideRatioErrorMessage, ex.getMessage());
    }


    // 3 same sides = Equilateral
    @Test
    @DisplayName("Side A = Side B = side C. Equilateral")
    void whenAllThreeSidesAreEqualTheTriangleIsEquilateral(){
        tri.setSideA(14);
        tri.setSideB(14);
        tri.setSideC(14);

        assertEquals(TriangleType.EQUILATERAL, tri.checkValidity());
    }


    // Two same sides = Isosceles
        // A = B != C -> Isosceles
        // A = C != B -> Isosceles
        // B = C != A -> Isosceles
    @Test
    @DisplayName("Side A = Side B != side C. Isosceles")
    void whenSideAAndSideBAreEqualTheTriangleIsIsosceles(){
        tri.setSideA(100);
        tri.setSideB(100);
        tri.setSideC(101);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }

    @Test
    @DisplayName("Side A = Side C != side B. Isosceles")
    void whenSideAAndSideCAreEqualTheTriangleIsIsosceles(){
        tri.setSideA(22);
        tri.setSideB(39);
        tri.setSideC(22);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }

    @Test
    @DisplayName("Side B = Side C != side A. Isosceles")
    void whenSideBAndSideCAreEqualTheTriangleIsIsosceles() {
        tri.setSideA(6);
        tri.setSideB(9);
        tri.setSideC(9);

        assertEquals(TriangleType.ISOSCELES, tri.checkValidity());
    }


    // 3 different sides = Scalene
    @Test
    @DisplayName("All different sides. Scalene")
    void whenAllThreeSidesAreDifferentTheTriangleIsScalene() {
        tri.setSideA(12);
        tri.setSideB(5);
        tri.setSideC(16);

        assertEquals(TriangleType.SCALENE, tri.checkValidity());
    }
}
