package com.example.gestorsp.gestorsp.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class DeletedException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DeletedException(String message) {
        super(message);
    }
    public DeletedException(String message, Throwable cause) {
        super(message, cause);
    }
}