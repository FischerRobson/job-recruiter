package com.example.jobrecruiter.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.jobrecruiter.constants.Constants;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {

    public String validateJWT(String token) {
        token = token.replace("Bearer ", "");

        try {
            return JWT.require(Constants.algorithm).build().verify(token).getSubject();
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return "";
        }
    }

}
