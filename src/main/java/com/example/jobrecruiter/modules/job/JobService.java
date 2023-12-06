package com.example.jobrecruiter.modules.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job create(Job job) {
        return this.jobRepository.save(job);
    }

}
