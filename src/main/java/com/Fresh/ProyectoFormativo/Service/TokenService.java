package com.Fresh.ProyectoFormativo.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class TokenService {
    @Value("Fresh%%SM1Le%%CM1LL5%%Ondon70logia2O23")
    private String jwtKey;

    public String generateToken(String email, int Id) {
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(email)
                .claim("email", email)
                .claim("userId", Id)
                .build();
        String jwtToken = Jwts.builder()
            .setSubject("subject")
            .setAudience("freshsmile")
            .setClaims(claims.getClaims())
            .signWith(SignatureAlgorithm.HS256, jwtKey.getBytes())
            .compact();
        return jwtToken;
    }

}