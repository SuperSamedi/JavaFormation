package brussels.digitalcity.maxdolmans.demorest.exceptions;

import java.util.List;

public class InvalidReferenceException extends RuntimeException {
    private final List<? extends Object> notFound;

    public InvalidReferenceException(List<? extends Object> notFound) {
        super("The following IDs were not found : " + notFound);
        this.notFound = notFound;
    }

    public InvalidReferenceException(String message, List<? extends Object> notFound) {
        super(message);
        this.notFound = notFound;
    }

    public List<? extends Object> getNotFound() {
        return notFound;
    }
}
