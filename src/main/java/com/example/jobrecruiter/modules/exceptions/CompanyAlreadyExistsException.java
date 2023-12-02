package com.example.jobrecruiter.modules.exceptions;

public class CompanyAlreadyExistsException extends RuntimeException{
    public CompanyAlreadyExistsException() {
        super("Company already exists");
    }
}
