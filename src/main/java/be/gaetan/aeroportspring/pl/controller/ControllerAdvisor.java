package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.pl.models.error.Error;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerAdvisor {
    /**
     * Handle method for IllegalArgumentException.
     * Creates an Error object with the provided message, HttpStatus.BAD_REQUEST status,
     * current LocalDateTime, and the requested URI. Returns a ResponseEntity with the Error body.
     *
     * @param e       The IllegalArgumentException.
     * @param request The HttpServletRequest.
     * @return A ResponseEntity containing the Error body.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> illegalArgument(IllegalArgumentException e, HttpServletRequest request){
        Error error = Error.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .requestMadeAt(LocalDateTime.now())
                .URI(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
