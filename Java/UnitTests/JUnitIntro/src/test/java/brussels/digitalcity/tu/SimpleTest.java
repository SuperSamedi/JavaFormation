package brussels.digitalcity.tu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

     @Test
     @DisplayName("Addition calculus success")
     @Order(1)
     void testCalcSuccess() {
          // ARRANGE
          int a = 3, b = 4, result;

          // ACT
          result = new Calculation().addition(a, b);

          // ASSERT
          assertEquals(7, result);
    }

     @Test
     void testCalcFailed() {
          // ARRANGE
          int a = 3, b = 4;
          int result;

          // ACT
          result = a + b;

          // ASSERT
          assertNotEquals(8, result);
     }

     @Test
     void divisionByZeroMustReturnException(){
         // Arrange
         Class<ArithmeticException> clazz = ArithmeticException.class;
         int theVictim = 3;
         int theBigBaddie = 0;

         // Act + Assert
         ArithmeticException exception = assertThrows(clazz, () -> {
             int theMassacre = theVictim / theBigBaddie;
         });

         assertEquals("/ by zero", exception.getMessage());
     }
}
