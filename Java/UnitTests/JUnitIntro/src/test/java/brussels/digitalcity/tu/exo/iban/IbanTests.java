package brussels.digitalcity.tu.exo.iban;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class IbanTests {

    String iban = "BE17063918152121";
//    String iban = "BE86966011908250";
    Iban ibanTest = new Iban();

    @BeforeEach
    void beforeEachTest(){
        ibanTest.setChain(iban);
    }


    // Iban is a 16 char string
    // Should begin with "BE"
    // Control key (2 digits)
    // BBAN (basic bank account number) (12 numbers)
        // Bank number (3 digits)
        // Account number (7 digits)
        // National code (2 digits)
    // Last 2 numbers are equal to modulo of the 10 digits before the last 2.

        @Test
        void ibanIsNull(){
            ibanTest.setChain(null);

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_NULL, ex.getMessage());
        }

        @Test
        void ibanShouldNotHaveSpaces() throws IbanException{
            ibanTest.setChain("BE17 0639 1815 2121");

            ibanTest.checkValidity();

            assertEquals("BE17063918152121", ibanTest.getChain());
        }

        @Test
        void lessThanSixteenCharsLong(){
            ibanTest.setChain("BE9098762833273");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_TOO_SHORT, ex.getMessage());
        }

        @Test
        void moreThanSixteenCharsLong(){
            ibanTest.setChain("BE87nhufhufrhgribgeshhdqhnyntnq");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_TOO_LONG, ex.getMessage());
        }

        @Test
        void startsWithSomethingOtherThanBE() {
            ibanTest.setChain("GH55666633332222");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_WRONG_START, ex.getMessage());
        }

        @Test
        void lastTwoDigitsShouldBeDigits(){
            ibanTest.setChain("BE89 8585 8787 85hj");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_BBAN_WRONG_FORMAT, ex.getMessage());
        }

        @Test
        void lastFourteenDigitsShouldDigits(){
            ibanTest.setChain("BE56 54hd k231 5477");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_BBAN_WRONG_FORMAT, ex.getMessage());
        }

        @Test
        void checkNinetysevenShouldHaveAnBbanModuloZero(){
            ibanTest.setChain("BE57 8795 9584 7897");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_CHECK_97_BAD_MODULO, ex.getMessage());
        }

        @Test
        void checkNotEqualToModuloOfBban() {
            ibanTest.setChain("BE17 0639 1815 2161");

            IbanException ex = assertThrows(IbanException.class, ibanTest::checkValidity);
            assertEquals(MessageExceptionIban.STRING_BBAN_BAD_MODULO, ex.getMessage());
        }
}
