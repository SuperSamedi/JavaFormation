package brussels.digitalcity.maxdolmans.demorest.controllers;

import brussels.digitalcity.maxdolmans.demorest.exceptions.DeleteReferencedEntityException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.ElementNotFoundException;
import brussels.digitalcity.maxdolmans.demorest.exceptions.InvalidReferenceException;
import brussels.digitalcity.maxdolmans.demorest.models.dtos.ErrorDTO;
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
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt(LocalDateTime.now())
                                .status(HttpStatus.NOT_FOUND.value())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .path(request.getRequestURL().toString())
                                .build()
                                .addInfo("zut", "Oh ben mince !")
                                .addInfo("de zut", "Quelle malchance...")
                );
    }

    @ExceptionHandler(DeleteReferencedEntityException.class)
    public ResponseEntity<ErrorDTO> handleException(DeleteReferencedEntityException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .method(HttpMethod.resolve(request.getMethod()))
                                .path(request.getRequestURL().toString())
                                .build()
                );
    }

    @ExceptionHandler(InvalidReferenceException.class)
    public ResponseEntity<ErrorDTO> handleException(InvalidReferenceException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(
                        ErrorDTO.builder()
                                .message(ex.getMessage())
                                .receivedAt(LocalDateTime.now())
                                .status(422)
                                .method(HttpMethod.resolve(request.getMethod()))
                                .path(request.getRequestURL().toString())
                                .build()
                                .addInfo("Invalid references", ex.getNotFound())
                );
    }
}
