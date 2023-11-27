package com.example.jobrecruiter.modules.candidate;

import com.example.jobrecruiter.modules.candidate.Candidate;
import com.example.jobrecruiter.modules.exceptions.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CandidateService candidateService;

    @PostMapping("")
    public ResponseEntity create(@Valid @RequestBody Candidate body) {
        try {
            Candidate candidate = this.candidateService.create(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
