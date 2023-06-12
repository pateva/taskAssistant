package com.example.taskAssistant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnableToMakeChangesException extends RuntimeException{
    public UnableToMakeChangesException(String message) {
        super(message);
    }
}
