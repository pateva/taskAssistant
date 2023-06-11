package com.example.taskAssistant.exceptions;


import com.example.taskAssistant.dto.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UnableToMakeChangesExceptionHandler {
    @ExceptionHandler(UnableToMakeChangesException.class)
    public ResponseEntity<TaskDto> handleException(Exception exception) {
        if(exception instanceof ResourceNotFoundException) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
