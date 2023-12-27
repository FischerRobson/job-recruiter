package com.example.jobrecruiter.security;

import com.example.jobrecruiter.providers.JWTProvider;
import com.sun.net.httpserver.Headers;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.function.ServerRequest;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String header = request.getHeader("Authorization");

        if (header != null) {
            String tokenSubject = jwtProvider.validateJWT(header);
            if (tokenSubject.isEmpty()) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }

//            request.setAttribute("");
        }



        filterChain.doFilter(request, response);
    }
}
