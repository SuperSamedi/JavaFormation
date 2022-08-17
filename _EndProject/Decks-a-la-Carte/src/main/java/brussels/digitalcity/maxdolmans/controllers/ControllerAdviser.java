package brussels.digitalcity.maxdolmans.controllers;

import brussels.digitalcity.maxdolmans.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.models.dtos.ErrorDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(ElementNotFoundException ex, HttpServletRequest request) {
        ErrorDTO dto = new ErrorDTO();

        dto.setReceivedAt(LocalDateTime.now());
        dto.setMessage(ex.getMessage());
        dto.setStatus(404);
        dto.setMethod(HttpMethod.resolve(request.getMethod()));
        dto.setPath(request.getRequestURL().toString());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body( dto );
    }
}
