package com.example.rest.api.crud.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
