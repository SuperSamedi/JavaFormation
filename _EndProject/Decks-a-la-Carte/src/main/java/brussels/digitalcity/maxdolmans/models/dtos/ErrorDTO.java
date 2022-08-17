package brussels.digitalcity.maxdolmans.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.http.HttpMethod;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class ErrorDTO {

    private LocalDateTime receivedAt;
    private String message;
    private int status;
    private HttpMethod method;
    private String path;
    private Map<String, Object> info = new HashMap<>();



    public void setReceivedAt(LocalDateTime value) {
        receivedAt = value;
    }

    public void setMessage(String value) {
        message = value;
    }

    public void setStatus(int value) {
        status = value;
    }

    public void setMethod(HttpMethod value) {
        method = value;
    }

    public void setPath(String value) {
        path = value;
    }

    public void addInfo(String key, Object value) {
        info.put(key, value);
    }

}
