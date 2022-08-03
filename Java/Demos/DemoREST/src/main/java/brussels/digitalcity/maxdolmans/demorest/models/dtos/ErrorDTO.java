package brussels.digitalcity.maxdolmans.demorest.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Builder
@Getter @Setter
public class ErrorDTO {
    private LocalDateTime receivedAt;
    private HttpMethod method;
    private String path;
    private String message;
    private HttpStatus status;
    private Map<String, Object> infos = new HashMap<>();

    public ErrorDTO addInfo(String key, Object value) {
        infos.put(key, value);
        return this;
    }
}
