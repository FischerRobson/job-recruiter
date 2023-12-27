package com.example.jobrecruiter.modules.company;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jobrecruiter.constants.Constants;
import com.example.jobrecruiter.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

@Service
public class AuthCompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${security.token.secret}")
    private String secret;

    public String authenticate(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        Company company = companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException()
        );

        boolean passwordsMatches = passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordsMatches) {
            throw new AuthenticationException();
        }

        return JWT.create().withIssuer("fischer")
                .withSubject(company.getId().toString())
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .sign(Constants.algorithm); // maybe not work
    }

}
