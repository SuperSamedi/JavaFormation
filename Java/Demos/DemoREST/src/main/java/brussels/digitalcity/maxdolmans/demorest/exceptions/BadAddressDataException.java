package brussels.digitalcity.maxdolmans.demorest.exceptions;

public class BadAddressDataException extends RuntimeException {

    public BadAddressDataException() {
        super("Error - Some address data are badly formatted.");
    }

}
