package com.example.jobrecruiter.modules.candidate;

import com.example.jobrecruiter.modules.candidate.Candidate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping
    public void create(@RequestBody Candidate body) {

    }
}