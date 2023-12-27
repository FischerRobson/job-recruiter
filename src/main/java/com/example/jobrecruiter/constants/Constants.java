package com.example.jobrecruiter.constants;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class Constants {
    @Value("${security.token.secret}")
    private static String secret;

    public static final Algorithm algorithm = Algorithm.HMAC256(secret);
}
