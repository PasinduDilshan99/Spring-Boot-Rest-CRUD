package com.example.rest.api.crud.exception;

import com.example.rest.api.crud.entity.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> studentNotFoundExceptionHandler(StudentNotFoundException e){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(404);
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> exceptionHandler(Exception e){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(400);
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> employeeNotFoundExceptionHandler(EmployeeNotFoundException e){
        ExceptionResponse response = new ExceptionResponse();
        response.setStatus(404);
        response.setMessage(e.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
