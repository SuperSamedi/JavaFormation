package brussels.digitalcity.maxdolmans.demorest.exceptions;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class FormValidationException extends RuntimeException {

    private final MultiValueMap<String, String> messages;

    public FormValidationException(MultiValueMap<String, String> messages) {
        super("One or more invalid values where found in the data");
        this.messages = messages;
    }

    public MultiValueMap<String, String> getMessages() {
        return new LinkedMultiValueMap<>(messages);
    }
}
