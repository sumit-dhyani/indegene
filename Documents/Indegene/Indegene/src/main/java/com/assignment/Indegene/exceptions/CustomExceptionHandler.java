package com.assignment.Indegene.exceptions;

import com.assignment.Indegene.model.ErrorEntity;
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
    public ErrorEntity resourceNotFound(WebRequest request, RecordNotFound ex){
        ErrorEntity errorMessage=new ErrorEntity(HttpStatus.NOT_FOUND.value(),LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return errorMessage;
    }

    @ExceptionHandler(value = ChannelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorEntity channelNotFound(WebRequest request, ChannelNotFoundException ex){
        ErrorEntity errorMessage=new ErrorEntity(HttpStatus.NOT_FOUND.value(),LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return errorMessage;
    }
}
