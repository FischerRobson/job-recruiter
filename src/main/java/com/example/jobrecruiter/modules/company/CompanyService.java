package com.example.jobrecruiter.modules.company;

import com.example.jobrecruiter.modules.exceptions.CompanyAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository repository;

    public void create(Company company) {

        Optional<Company> companyExists = this.repository.findByUsernameOrEmail(company.getUsername(), company.getEmail());
        if (companyExists.isPresent()) {
            throw new CompanyAlreadyExistsException();
        } else {
            this.repository.save(company);
        }

    }

}
