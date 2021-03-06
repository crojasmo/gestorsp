package com.example.gestorsp.gestorsp.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreateException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CreateException(String message) {
        super(message);
    }
    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}