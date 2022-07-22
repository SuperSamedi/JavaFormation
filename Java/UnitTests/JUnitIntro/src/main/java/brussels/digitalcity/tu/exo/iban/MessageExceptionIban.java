package brussels.digitalcity.tu.exo.iban;

public class MessageExceptionIban {
    public static final String STRING_NULL = "The Iban string cannot be null";
    public static final String STRING_TOO_SHORT = "The Iban string cannot be shorter than 16 digits";
    public static final String STRING_TOO_LONG = "The Iban string cannot be longer than 16 digits";
    public static final String STRING_WRONG_START = "The Iban string should begin with \"BE\"";
    public static final String STRING_BBAN_WRONG_FORMAT = "The bban part has the wrong format (should only be composed of numbers)";
    public static final String STRING_CHECK_WRONG_FORMAT = "The check part has the wrong format (should only be composed of numbers)";
    public static final String STRING_BBAN_BAD_MODULO = "The bban is not correct.";
    public static final String STRING_CHECK_97_BAD_MODULO = "The check 97 is not correct.";
}
