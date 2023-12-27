package com.example.jobrecruiter.modules.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    AuthCompanyService authCompanyService;

    @PostMapping("/company")
    public ResponseEntity authenticate(@RequestBody AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.authCompanyService.authenticate(authCompanyDTO));
        } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
