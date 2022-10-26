package com.assignment.Indegene.exceptions;

import com.assignment.Indegene.model.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = RecordNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMsg resourceNotFound(WebRequest request,RecordNotFound ex){
        ResponseMsg message=new ResponseMsg(HttpStatus.NOT_FOUND.value(),LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return message;
    }
}
