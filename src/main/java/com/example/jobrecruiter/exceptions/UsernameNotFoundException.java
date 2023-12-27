package com.example.jobrecruiter.exceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException() {
        super("Username/Password incorrect");
    }
}
