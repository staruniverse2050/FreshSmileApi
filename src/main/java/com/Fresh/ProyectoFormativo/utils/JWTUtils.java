package com.Fresh.ProyectoFormativo.utils;


import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class JWTUtils {
    private String jwtKey = "Fresh%%SM1Le%%CM1LL5%%Ondon70logia2O23";

    private SecretKey key;

    public JWTUtils(){
        this.key = new SecretKeySpec(this.jwtKey.getBytes(StandardCharsets.UTF_8), "HMACSHA256");
    }

    public Claims getTokenClaims(String token){
            JwtParser builder = Jwts.parserBuilder().setSigningKey(key).build();
            Jws<Claims> claims = builder.parseClaimsJws(token);
            return claims.getBody();
    }
}
