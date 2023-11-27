package com.example.jobrecruiter.modules.company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "\\S+", message = "Username cant have empty spaces")
    private String username;

    @Email(message = "Email invalid")
    private String email;

    @Length(min = 10, max = 14, message = "Length must be between 10 and 14 characters")
    private String password;

    private String website;
    private String document;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
