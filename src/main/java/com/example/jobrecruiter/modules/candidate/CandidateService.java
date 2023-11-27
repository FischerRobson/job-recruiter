package com.example.jobrecruiter.modules.candidate;

import com.example.jobrecruiter.modules.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate create(Candidate body) {
        Optional<Candidate> candidateExists = this.candidateRepository.findByUsernameOrEmail(body.getUsername(), body.getEmail());

        if (candidateExists.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        return this.candidateRepository.save(body);
    }
}
