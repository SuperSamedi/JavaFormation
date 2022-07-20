package brussels.digitalcity.tu;

import brussels.digitalcity.tu.exo.triangle.Triangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestsTriangle {
    private final Triangle tri = new Triangle();

    private final int[] values = {-100, -1, 0, 1, 100};

    // side A must be strictly positive
    // side B must be strictly positive
    // side C must be strictly positive
    @ParameterizedTest
    @ValueSource(values)
    void testAGreaterThanZero(){
        // ARRANGE
        tri.set

        // ACT
        result = new Calculation().addition(a, b);

        // ASSERT
        assertEquals(7, result);
    }

    // A + B must be greater than C
    // A + C must be greater than B
    // B + C must be greater than A

    // 3 different sides = Scalene
    // 2 same sides = Isosceles
    // 3 same sides = Equilateral


}
