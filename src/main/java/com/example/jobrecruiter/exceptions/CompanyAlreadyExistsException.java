package com.example.jobrecruiter.exceptions;

public class CompanyAlreadyExistsException extends RuntimeException{
    public CompanyAlreadyExistsException() {
        super("Company already exists");
    }
}
