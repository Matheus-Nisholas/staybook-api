package com.nisholas.staybook.infrastructure.Exception;

import com.nisholas.staybook.core.Exception.DuplicateEnderecoException;
import com.nisholas.staybook.core.Exception.NotFoundAcomodaçaoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(DuplicateEnderecoException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEnderecoException(DuplicateEnderecoException ex,
                                                                          HttpServletRequest request) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(NotFoundAcomodaçaoException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundAcomodaçaoException(NotFoundAcomodaçaoException ex,
                                                                           HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
