package be.gaetan.aeroportspring.pl.controller;

import be.gaetan.aeroportspring.pl.models.error.Error;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;

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


    /**
     * Handles the EntityNotFoundException by creating an Error object with the provided exception message,
     * HttpStatus.NOT_FOUND status, current LocalDateTime, and the requested URI.
     * Returns a ResponseEntity object with the Error body.
     *
     * @param e The EntityNotFoundException that occurred.
     * @param request The HttpServletRequest object representing the current request.
     * @return A ResponseEntity object containing the Error body.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleNotFoundException(EntityNotFoundException e, HttpServletRequest request){
        Error error = Error.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(e.getMessage())
                .requestMadeAt(LocalDateTime.now())
                .URI(request.getRequestURI())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
