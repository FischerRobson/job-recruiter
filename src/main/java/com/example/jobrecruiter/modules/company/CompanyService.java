package com.example.jobrecruiter.modules.company;

import com.example.jobrecruiter.exceptions.CompanyAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Company create(Company company) {

        Optional<Company> companyExists = this.repository.findByUsernameOrEmail(company.getUsername(), company.getEmail());
        if (companyExists.isPresent()) {
            throw new CompanyAlreadyExistsException();
        } else {
            String encodedPassword = passwordEncoder.encode(company.getPassword());
            company.setPassword(encodedPassword);
            return this.repository.save(company);
        }
    }

}
