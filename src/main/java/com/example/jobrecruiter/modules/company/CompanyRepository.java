package com.example.jobrecruiter.modules.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {

    Optional<Company> findByUsernameOrEmail(String username, String email);

}
