package com.example.jobrecruiter.modules.company;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;
    private String level;
    private String benefits;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
