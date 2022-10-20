package com.assignment.Indegene.exceptions;

import com.assignment.Indegene.model.ResponseMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = RecordNotFound.class)
    public ResponseEntity<ResponseMsg> recordNotFound(WebRequest request,RecordNotFound ex){
        ResponseMsg message=new ResponseMsg(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
