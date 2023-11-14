package com.example.jobrecruiter.modules.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class Candidate {
    private UUID id;

    @Pattern(regexp = "\\S+", message = "Username cant have empty spaces")
    private String name;
    private String username;

    @Email(message = "Email invalid")
    private String email;

    @Length(min = 10, max = 14, message = "Length must be between 10 and 14 characters")
    private String password;
    private String description;
    private String curriculum;

}
